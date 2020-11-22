package com.ourhome.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ourhome.dto.CustomTests;
import com.ourhome.service.CustomTestsServiceImpl;

@RestController
@RequestMapping("/api/customTests")
public class CustomTestsController {
	
	@Autowired
	CustomTestsServiceImpl customTestsServiceImpl;
	
	@GetMapping()
	public List<CustomTests> listCustomTests(){
		return customTestsServiceImpl.listCustomTests();
	}
		
	@GetMapping("/{id}")
	public CustomTests searchCustomTest(@PathVariable(name = "id") int id) {
		CustomTests customTest = new CustomTests();		
		customTest = customTestsServiceImpl.searchCustomTest(id);
		
		return customTest;
	}

	@GetMapping("/user/{user_id}")
	public CustomTests searchCustomTestByUser(@PathVariable(name = "user_id") int user_id) {
		CustomTests customTest = new CustomTests();
		customTest = customTestsServiceImpl.searchCustomTestByUser(user_id);

		return customTest;
	}

	@PostMapping()
	public CustomTests saveCustomTest(@RequestBody CustomTests customTest) {
		return customTestsServiceImpl.saveCustomTest(customTest);
	}
		
	@PutMapping("/{id}")
	public CustomTests updateCustomTest(@PathVariable(name = "id") int id, @RequestBody CustomTests customTest) {
		CustomTests customTestsSelected = new CustomTests();
		CustomTests customTestsUpdated = new CustomTests();
		
		customTestsSelected = customTestsServiceImpl.searchCustomTest(id);
		
		customTestsSelected.setUser(customTest.getUser());
		customTestsSelected.setQuestions(customTest.getQuestions());
		customTestsSelected.setAnswers(customTest.getAnswers());
		customTestsSelected.setOptions1(customTest.getOptions1());
		customTestsSelected.setOptions2(customTest.getOptions2());
		customTestsSelected.setCreatedAt(customTest.getCreatedAt());

		customTestsUpdated = customTestsServiceImpl.updateCustomTest(customTestsSelected);
		
		return customTestsUpdated;
	}
	
	@DeleteMapping("/{id}")
	public void deleteCustomTest(@PathVariable(name = "id") int id) {
		customTestsServiceImpl.deleteCustomTest(id);
	}

}
