package com.ourhome.controller;

import com.ourhome.dto.Users;
import com.ourhome.service.UsersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    @Autowired
    UsersServiceImpl usersServiceImpl;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UsersController(BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @GetMapping()
    public List<Users> listUsers() {
        return usersServiceImpl.listUsers();
    }

    @GetMapping("/{id}")
    public Users searchUser(@PathVariable(name = "id") int id) {
        return usersServiceImpl.searchUser(id);
    }

    @GetMapping("/public/email/{email}")
    public Users searchUserByEmail(@PathVariable(name = "email") String email) {
        return usersServiceImpl.searchUserByEmail(email);
    }

    @PostMapping("/public/")
    public Users saveUser(@RequestPart(name = "profilePicture", required = false) MultipartFile profilePicture, @RequestPart(name = "user") Users user) throws IOException {
        if ((profilePicture != null)) {
            user.setProfilePicture(profilePicture.getBytes());
        }

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        return usersServiceImpl.saveUser(user);
    }

    @PutMapping()
    public Users updateUser(@RequestPart(name = "profilePicture", required = false) MultipartFile profilePicture, @RequestPart(name = "user") Users user) throws IOException {
        Users userSaved = usersServiceImpl.searchUser(user.getId());

        if (profilePicture != null) {
            user.setProfilePicture(profilePicture.getBytes());
        }

        if (!user.getPassword().equals(userSaved.getPassword())) {
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        }

        user.setHomes(userSaved.getHomes());
        user.setProcess(userSaved.getProcess());
        user.setCustomTest(userSaved.getCustomTest());
        user.setNotifications(userSaved.getNotifications());
        user.setTokens(userSaved.getTokens());

        return usersServiceImpl.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable(name = "id") int id) {
        usersServiceImpl.deleteUser(id);
    }

}
