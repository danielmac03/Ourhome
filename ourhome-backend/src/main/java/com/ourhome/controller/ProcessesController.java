package com.ourhome.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import com.ourhome.dto.Processes;
import com.ourhome.service.ProcessesServiceImpl;

@RestController
@RequestMapping("/api/processes")
public class ProcessesController {

	@Autowired
	ProcessesServiceImpl processesServiceImpl;
	
	@GetMapping()
	public List<Processes> listProcesses(){
		return processesServiceImpl.listProcesses();
	}

	@GetMapping("/{id}")
	public Processes searchProcess(@PathVariable(name = "id") int id) {
		return processesServiceImpl.getProcess(id);
	}

	@GetMapping("/home/{home_id}")
	public List<Processes> listProcessByHome(@PathVariable(name = "home_id") int home_id){
		return processesServiceImpl.listProcessByHome(home_id);
	}

	@GetMapping("/user/{user_id}")
	public List<Processes> listProcessByUser(@PathVariable(name = "user_id") int userId){
		return processesServiceImpl.listProcessByUser(userId);
	}

	@PostMapping()
	public Processes saveProcess(@RequestBody Processes process) {
		return processesServiceImpl.saveProcess(process);
	}

	@PutMapping("/{id}")
	public Processes updateProcess(@PathVariable(name = "id") int id, @RequestBody Processes process) {
		return this.processesServiceImpl.updateProcess(process);
	}

	@DeleteMapping("{id}")
	public void deleteProcess(@PathVariable(name = "id") int id) {
		processesServiceImpl.deleteProcess(id);
	}

	@Transactional
	@DeleteMapping("/home/{home_id}")
	public void deleteProcessesByHome(@PathVariable(name = "home_id") int homeId) {
		processesServiceImpl.deleteProcessesByHome(homeId);
	}
	
}
