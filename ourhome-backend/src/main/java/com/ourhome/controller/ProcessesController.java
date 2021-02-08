package com.ourhome.controller;

import com.ourhome.dto.Notifications;
import com.ourhome.dto.Processes;
import com.ourhome.implemention.NotificationsServiceImpl;
import com.ourhome.implemention.ProcessesServiceImpl;
import com.ourhome.security.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/processes")
public class ProcessesController {

    @Autowired
    ProcessesServiceImpl processesServiceImpl;

    @Autowired
    NotificationsServiceImpl notificationsServiceImpl;

    @GetMapping()
    public List<Processes> listProcesses() {
        return processesServiceImpl.listProcesses();
    }

    @PreAuthorize("hasAnyAuthority('search', 'have', 'business')")
    @GetMapping("/{id}")
    public Processes searchProcess(@PathVariable(name = "id") int id) {
        return processesServiceImpl.getProcess(id);
    }

    @PreAuthorize("hasAnyAuthority('search', 'have', 'business')")
    @GetMapping("/user/{user_id}")
    public List<Processes> listProcessByUser(@PathVariable(name = "user_id") int userId) {
        return processesServiceImpl.listProcessByUser(userId);
    }

    @PreAuthorize("hasAnyAuthority('have', 'business')")
    @GetMapping("/home/{home_id}")
    public List<Processes> listProcessByHome(@PathVariable(name = "home_id") int homeId) {
        return processesServiceImpl.listProcessByHome(homeId);
    }

    @PreAuthorize("hasAnyAuthority('search', 'have', 'business')")
    @GetMapping("/{home_id}/{user_id}")
    public boolean existProcess(@PathVariable(name = "home_id") int homeId, @PathVariable(name = "user_id") int userId) {
        Processes process = processesServiceImpl.getProcessByHomeAndUser(homeId, userId);
        return process != null;
    }

    @PreAuthorize("hasAuthority('search')")
    @PostMapping()
    public Processes saveProcess(@RequestBody Processes process) {
        Processes saveProcess = processesServiceImpl.saveProcess(process);
        notificationsServiceImpl.saveNotification(new Notifications(0, saveProcess.getUser(), "Se ha creado correctamente el processo", saveProcess.getHome().getPhotos().length != 0 ? saveProcess.getHome().getPhotos()[0] : null, Constants.URL + "list-processes", null));

        return saveProcess;
    }

    @PreAuthorize("hasAnyAuthority('search', 'have', 'business')")
    @DeleteMapping("{id}/{role}")
    public void deleteProcess(@PathVariable(name = "id") int id, @PathVariable(name = "role") String role) {
        Processes process = processesServiceImpl.getProcess(id);
        if (role.equals("search")) {
            notificationsServiceImpl.saveNotification(new Notifications(0, process.getUser(), "Se ha eliminado correctamente la solicitud", process.getHome().getPhotos().length != 0 ? process.getHome().getPhotos()[0] : null, Constants.URL + "list-processes", null));
            notificationsServiceImpl.saveNotification(new Notifications(0, process.getHome().getUser(), process.getUser().getName() + process.getUser().getSurnames() + " " + "ha retirado su solicitud", process.getUser().getProfilePicture(), Constants.URL + "see-requests/" + process.getHome().getId(), null));
        } else if (role.equals("have") || role.equals("business")) {
            notificationsServiceImpl.saveNotification(new Notifications(0, process.getHome().getUser(), "Se ha eliminado correctamente la solicitud de" + " " + process.getUser().getName() + process.getUser().getSurnames(), process.getUser().getProfilePicture(), Constants.URL + "see-requests/" + process.getHome().getId(), null));
            notificationsServiceImpl.saveNotification(new Notifications(0, process.getUser(), "Se ha rechazado su solicitud", process.getHome().getPhotos().length != 0 ? process.getHome().getPhotos()[0] : null, Constants.URL + "list-processes", null));
        }

        processesServiceImpl.deleteProcess(id);
    }

    @PreAuthorize("hasAnyAuthority('have', 'business')")
    @Transactional
    @DeleteMapping("/home/{home_id}")
    public void deleteProcessesByHome(@PathVariable(name = "home_id") int homeId) {
        processesServiceImpl.deleteProcessesByHome(homeId);
    }

}
