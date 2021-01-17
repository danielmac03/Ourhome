package com.ourhome.controller;

import com.ourhome.dto.CustomTests;
import com.ourhome.implemention.CustomTestsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customTests")
public class CustomTestsController {

    @Autowired
    CustomTestsServiceImpl customTestsServiceImpl;

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
        return customTestsServiceImpl.saveCustomTest(customTest);
    }

    @PutMapping("/{id}")
    public CustomTests updateCustomTest(@PathVariable(name = "id") int id, @RequestBody CustomTests customTest) {
        return customTestsServiceImpl.updateCustomTest(customTest);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomTest(@PathVariable(name = "id") int id) {
        customTestsServiceImpl.deleteCustomTest(id);
    }

}
