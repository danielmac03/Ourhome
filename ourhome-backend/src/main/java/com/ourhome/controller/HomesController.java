package com.ourhome.controller;

import com.ourhome.dto.Homes;
import com.ourhome.service.HomesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/homes")
public class HomesController {

    @Autowired
    HomesServiceImpl homesServiceImpl;

    @GetMapping("/public/")
    public List<Homes> listHomes() {
        return homesServiceImpl.listHomes();
    }

    @GetMapping("/public/active/")
    public List<Homes> listActiveHomes() {
        return homesServiceImpl.listActiveHomes();
    }

    @GetMapping("/public/{id}")
    public Homes getHome(@PathVariable(name = "id") int id) {
        return homesServiceImpl.getHome(id);
    }

    @GetMapping("/user/{user_id}")
    public List<Homes> getHomesByUser(@PathVariable(name = "user_id") int user_id) {
        return homesServiceImpl.getHomesByUser(user_id);
    }

    @PostMapping()
    public Homes saveHomes(@RequestPart(name = "photos", required = false) MultipartFile[] photos, @RequestPart(name = "home") Homes home) throws IOException {
        byte[][] photosByte = new byte[photos.length][];

        if (photos.length != 0) {
            for (int i = 0; i < photos.length; i++) {
                photosByte[i] = photos[i].getBytes();
            }

            home.setPhotos(photosByte);
        }

        return homesServiceImpl.saveHomes(home);
    }

    @PutMapping()
    public Homes updateHome(@RequestPart(name = "photos", required = false) MultipartFile[] photos, @RequestPart(name = "home") Homes home) throws IOException {
        byte[][] photosByte = new byte[photos.length][];

        if (photos.length != 0) {
            for (int i = 0; i < photos.length; i++) {
                photosByte[i] = photos[i].getBytes();
            }

            home.setPhotos(photosByte);
        }

        home.setProcess(home.getProcess());

        return this.homesServiceImpl.updateHome(home);
    }

    @DeleteMapping("/{id}")
    public void deleteHome(@PathVariable(name = "id") int id) {
        homesServiceImpl.deleteHome(id);
    }

}
