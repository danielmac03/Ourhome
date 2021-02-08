package com.ourhome.controller;

import com.ourhome.dto.Homes;
import com.ourhome.dto.Notifications;
import com.ourhome.implemention.HomesServiceImpl;
import com.ourhome.implemention.NotificationsServiceImpl;
import com.ourhome.security.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/homes")
public class HomesController {

    @Autowired
    HomesServiceImpl homesServiceImpl;

    @Autowired
    NotificationsServiceImpl notificationsServiceImpl;

    @PreAuthorize("hasAuthority('admin')")
    @GetMapping()
    public List<Homes> listHomes() {
        return homesServiceImpl.listHomes();
    }

    @GetMapping("/public/active/")
    public List<Homes> listActiveHomes() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return homesServiceImpl.listActiveHomes();
    }

    @GetMapping("/public/{id}")
    public Homes getHome(@PathVariable(name = "id") int id) {
        return homesServiceImpl.getHome(id);
    }

    @PreAuthorize("hasAnyAuthority('have', 'business')")
    @GetMapping("/user/{user_id}")
    public List<Homes> getHomesByUser(@PathVariable(name = "user_id") int user_id) {
        return homesServiceImpl.getHomesByUser(user_id);
    }

    @PreAuthorize("hasAnyAuthority('have', 'business')")
    @PostMapping()
    public Homes saveHomes(@RequestPart(name = "photos", required = false) MultipartFile[] photos, @RequestPart(name = "home") Homes home) throws IOException {
        byte[][] photosByte = new byte[photos.length][];

        if (photos.length != 0) {
            for (int i = 0; i < photos.length; i++) {
                photosByte[i] = photos[i].getBytes();
            }

            home.setPhotos(photosByte);
        }

        Homes saveHome = homesServiceImpl.saveHomes(home);
        notificationsServiceImpl.saveNotification(new Notifications(0, saveHome.getUser(), "Se ha creado correctamente el anuncio", photos.length != 0 ? saveHome.getPhotos()[0] : null, Constants.URL + "see-advertisement/" + saveHome.getId(), null));

        return saveHome;
    }

    @PreAuthorize("hasAnyAuthority('have', 'business')")
    @PutMapping()
    public Homes updateHome(@RequestPart(name = "photos", required = false) MultipartFile[] photos, @RequestPart(name = "home") Homes home) throws IOException {
        Homes homeSaved = homesServiceImpl.getHome(home.getId());

        byte[][] photosByte = new byte[photos.length][];

        if (photos.length != 0) {
            for (int i = 0; i < photos.length; i++) {
                photosByte[i] = photos[i].getBytes();
            }

            home.setPhotos(photosByte);
        }

        home.setProcess(homeSaved.getProcess());

        Homes updateHome = homesServiceImpl.updateHome(home);
        notificationsServiceImpl.saveNotification(new Notifications(0, updateHome.getUser(), "Se ha actualizado correctamente el anuncio", photos.length != 0 ? updateHome.getPhotos()[0] : null, Constants.URL + "see-advertisement/" + updateHome.getId(), null));

        return updateHome;
    }

    @PreAuthorize("hasAnyAuthority('have', 'business')")
    @DeleteMapping("/{id}")
    public void deleteHome(@PathVariable(name = "id") int id) {
        Homes home = homesServiceImpl.getHome(id);
        notificationsServiceImpl.saveNotification(new Notifications(0, home.getUser(), "Se ha eliminado correctamente el anuncio", home.getPhotos().length != 0 ? home.getPhotos()[0] : null, null, null));

        homesServiceImpl.deleteHome(id);
    }

}
