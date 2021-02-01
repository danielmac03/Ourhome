package com.ourhome.controller;

import com.ourhome.dto.CustomTests;
import com.ourhome.dto.Notifications;
import com.ourhome.implemention.CustomTestsServiceImpl;
import com.ourhome.implemention.NotificationsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customTests")
public class CustomTestsController {

    @Autowired
    CustomTestsServiceImpl customTestsServiceImpl;

    @Autowired
    NotificationsServiceImpl notificationsServiceImpl;

    @GetMapping()
    public List<CustomTests> listCustomTests() {
        return customTestsServiceImpl.listCustomTests();
    }

    @GetMapping("/{id}")
    public CustomTests searchCustomTest(@PathVariable(name = "id") int id) {
        return customTestsServiceImpl.searchCustomTest(id);
    }

    @GetMapping("/user/{user_id}")
    public CustomTests searchCustomTestByUser(@PathVariable(name = "user_id") int user_id) {
        return customTestsServiceImpl.searchCustomTestByUser(user_id);
    }

    @PostMapping()
    public CustomTests saveCustomTest(@RequestBody CustomTests customTest) {
        CustomTests saveCustomTest = customTestsServiceImpl.saveCustomTest(customTest);
        notificationsServiceImpl.saveNotification(new Notifications(0, saveCustomTest.getUser(), "Se ha creado correctamente el test", null, null, null));

        return saveCustomTest;
    }

    @PutMapping()
    public CustomTests updateCustomTest(@RequestBody CustomTests customTest) {
        CustomTests updateCustomTest = customTestsServiceImpl.updateCustomTest(customTest);
        notificationsServiceImpl.saveNotification(new Notifications(0, updateCustomTest.getUser(), "Se ha actualizado correctamente el test", null, null, null));

        return updateCustomTest;
    }

    @DeleteMapping("/{id}")
    public void deleteCustomTest(@PathVariable(name = "id") int id) {
        CustomTests customTest = searchCustomTest(id);
        notificationsServiceImpl.saveNotification(new Notifications(0, customTest.getUser(), "Se ha eliminado correctamente el test", null, null, null));

        customTestsServiceImpl.deleteCustomTest(id);
    }

}
