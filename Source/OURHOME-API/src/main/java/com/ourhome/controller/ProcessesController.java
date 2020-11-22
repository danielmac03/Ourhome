package com.ourhome.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
		Processes process = new Processes();		
		process = processesServiceImpl.getProcess(id);
		
		return process;
	}

	@GetMapping("/home/{home_id}")
	public List<Processes> listProcessByHome(@PathVariable(name = "home_id") int home_id){
		return processesServiceImpl.listProcessByHome(home_id);
	}

	@GetMapping("/user/{user_id}")
	public List<Processes> listProcessByUser(@PathVariable(name = "user_id") int user_id){
		return processesServiceImpl.listProcessByUser(user_id);
	}

	@PostMapping()
	public Processes saveProcess(@RequestBody Processes process) {
		return processesServiceImpl.saveProcess(process);
	}

	@PutMapping("/{id}")
	public Processes updateProcess(@PathVariable(name = "id") int id, @RequestBody Processes process) {
		Processes processSelected = new Processes();
		Processes processUpdated = new Processes();
		
		processSelected = processesServiceImpl.getProcess(id);
		
		processSelected.setHome(process.getHome());
		processSelected.setUser(process.getUser());
		processSelected.setAnswers(process.getAnswers());
		processSelected.setCompatibility(process.getCompatibility());
		processSelected.setCreatedAt(process.getCreatedAt());
		processSelected.setUpdatedAt(process.getUpdatedAt());

		processUpdated = this.processesServiceImpl.updateProcess(processSelected);
		
		return processUpdated;
	}
	
	@DeleteMapping("{id}")
	public void deleteProcess(@PathVariable(name = "id") int id) {
		processesServiceImpl.deleteProcess(id);
	}
	
}
