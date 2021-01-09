package com.ourhome.controller;

import com.ourhome.dto.Tokens;
import com.ourhome.dto.Users;
import com.ourhome.service.TokensServiceImpl;
import com.ourhome.service.UsersServiceImpl;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

import static com.ourhome.security.Constants.*;

@RestController
@RequestMapping("/api/recovery-passwords/public")
public class TokensController {

    @Autowired
    TokensServiceImpl tokensServiceImpl;

    @Autowired
    UsersServiceImpl usersServiceImpl;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public TokensController(BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("/forgot/")
    @ResponseStatus(value = HttpStatus.OK)
    public void forgotPassword(@RequestBody String email) {
        String generatedToken = Jwts.builder()
                .signWith(SignatureAlgorithm.HS512, SUPER_SECRET_KEY)
                .setIssuedAt(new Date())
                .setIssuer(ISSUER_INFO)
                .setSubject("recovery-password")
                .setExpiration(new Date(System.currentTimeMillis() + TOKEN_EXPIRATION_TIME))
                .compact();

        Tokens token = new Tokens();
        token.setUser(usersServiceImpl.searchUserByEmail(email));
        token.setToken(generatedToken);

        tokensServiceImpl.saveToken(token);
    }

    @PostMapping("/isValid/")
    public ResponseEntity<?> isValid(@RequestBody Tokens token) {
        Users user = usersServiceImpl.searchUserByEmail(token.getUser().getEmail());
        Tokens tokenSaved = tokensServiceImpl.getToken(user.getId(), token.getToken());

        String tokenParsed = Jwts.parser()
                .setSigningKey(SUPER_SECRET_KEY)
                .parseClaimsJws(tokenSaved.getToken().replace(TOKEN_BEARER_PREFIX, ""))
                .getBody()
                .getSubject();

        if (tokenParsed.equals("recovery-password")) {
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping("/recovery/")
    public ResponseEntity<?> recoveryPassword(@RequestPart(name = "token") Tokens token, @RequestPart(name = "password") String password) {
        Users user = usersServiceImpl.searchUserByEmail(token.getUser().getEmail());
        Tokens tokenSaved = tokensServiceImpl.getToken(user.getId(), token.getToken());

        String tokenParsed = Jwts.parser()
                .setSigningKey(SUPER_SECRET_KEY)
                .parseClaimsJws(tokenSaved.getToken().replace(TOKEN_BEARER_PREFIX, ""))
                .getBody()
                .getSubject();

        if (tokenParsed.equals("recovery-password")) {
            user.setPassword(bCryptPasswordEncoder.encode(password));
            usersServiceImpl.updateUser(user);

            tokensServiceImpl.deleteToken(tokenSaved.getId());

            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
