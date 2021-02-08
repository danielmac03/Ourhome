package com.ourhome.controller;

import com.ourhome.dto.Notifications;
import com.ourhome.dto.Users;
import com.ourhome.implemention.NotificationsServiceImpl;
import com.ourhome.implemention.UsersServiceImpl;
import com.ourhome.security.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @Autowired
    NotificationsServiceImpl notificationsServiceImpl;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UsersController(BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PreAuthorize("hasAuthority('admin')")
    @GetMapping()
    public List<Users> listUsers() {
        return usersServiceImpl.listUsers();
    }

    @PreAuthorize("hasAuthority('admin')")
    @GetMapping("/{id}")
    public Users searchUser(@PathVariable(name = "id") int id) {
        return usersServiceImpl.searchUser(id);
    }

    @PreAuthorize("hasAnyAuthority('search', 'have', 'business')")
    @GetMapping("/email/{email}")
    public Users searchUserByEmail(@PathVariable(name = "email") String email) {
        return usersServiceImpl.searchUserByEmail(email);
    }

    @GetMapping("/public/existEmail/{email}")
    public boolean existEmail(@PathVariable(name = "email") String email) {
        Users user = usersServiceImpl.searchUserByEmail(email);
        return user != null;
    }

    @PostMapping("/public/")
    public Users saveUser(@RequestPart(name = "profilePicture", required = false) MultipartFile profilePicture, @RequestPart(name = "user") Users user) throws IOException {
        if ((profilePicture != null)) {
            user.setProfilePicture(profilePicture.getBytes());
        }

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        Users saveUser = usersServiceImpl.saveUser(user);
        notificationsServiceImpl.saveNotification(new Notifications(0, saveUser, "Se ha creado correctamente el usuario", saveUser.getProfilePicture(), Constants.URL + "profile", null));

        return saveUser;
    }

    @PreAuthorize("hasAnyAuthority('search', 'have', 'business')")
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

        Users updateUser = usersServiceImpl.updateUser(user);
        notificationsServiceImpl.saveNotification(new Notifications(0, updateUser, "Se ha actualizado correctamente el usuario", updateUser.getProfilePicture(), Constants.URL + "profile", null));

        return updateUser;
    }

    @PreAuthorize("hasAnyAuthority('search', 'have', 'business')")
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable(name = "id") int id) {
        Users user = usersServiceImpl.searchUser(id);
        notificationsServiceImpl.saveNotification(new Notifications(0, user, "Se ha eliminado correctamente el usuario", user.getProfilePicture(), Constants.URL + "create-account", null));

        usersServiceImpl.deleteUser(id);
    }

}
