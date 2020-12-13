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

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    UsersServiceImpl usersServiceImpl;

    public UsersController(BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @GetMapping()
    public List<Users> listUsers() {
        return usersServiceImpl.listUsers();
    }

    @GetMapping("/{id}")
    public Users searchUser(@PathVariable(name = "id") int id) {
        Users user = new Users();
        user = usersServiceImpl.searchUser(id);

        return user;
    }

    @GetMapping("/public/email/{email}")
    public Users searchUserByEmail(@PathVariable(name = "email") String email) {
        Users user = new Users();
        user = usersServiceImpl.searchUserByEmail(email);

        return user;
    }

    @PostMapping("/public/")
    public Users saveUser(@RequestPart(name = "profilePicture") MultipartFile profilePicture, @RequestPart(name = "user") Users user) throws IOException {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return usersServiceImpl.saveUser(user, profilePicture);
    }

    @PutMapping()
    public Users updateUser(@RequestBody Users user) {
        Users userSaved = new Users();
        userSaved = usersServiceImpl.searchUserByEmail(user.getEmail());

        if(!user.getPassword().equals(userSaved.getPassword())){
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        }

        return usersServiceImpl.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable(name = "id") int id) {
        usersServiceImpl.deleteUser(id);
    }

}
