package com.ourhome.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ourhome.dto.Processes;
import com.ourhome.service.ProcessesServiceImpl;

@RestController
@RequestMapping("/api")
public class ProcessesController {

	@Autowired
	ProcessesServiceImpl processesServiceImpl;
	
	@GetMapping("/processes")
	public List<Processes> listProcesses(){
		return processesServiceImpl.listProcesses();
	}
	
	@PostMapping("/processes")
	public Processes saveProcess(@RequestBody Processes process) {
		return processesServiceImpl.saveProcess(process);
	}
	
	@GetMapping("/processes/{id}")
	public Processes searchProcess(@PathVariable(name = "id") int id) {
		Processes process = new Processes();		
		process = processesServiceImpl.getProcess(id);
		
		return process;
	}

	@GetMapping("/processes/home/{home_id}")
	public List<Processes> listProcessByHome(@PathVariable(name = "home_id") int home_id){
		return processesServiceImpl.listProcessByUser(home_id);
	}

	@GetMapping("/processes/user/{user_id}")
	public List<Processes> listProcessByUser(@PathVariable(name = "user_id") int user_id){
		return processesServiceImpl.listProcessByUser(user_id);
	}

	@PutMapping("/processes/{id}")
	public Processes actualizarProcess(@PathVariable(name = "id") int id, @RequestBody Processes process) {
		Processes processSelected = new Processes();
		Processes processUpdated = new Processes();
		
		processSelected = processesServiceImpl.getProcess(id);
		
		processSelected.setHome(process.getHome());
		processSelected.setUser(process.getUser());
		processSelected.setState(process.getState());
		processSelected.setCreatedAt(process.getCreatedAt());
		processSelected.setUpdatedAt(process.getUpdatedAt());
		
		return processUpdated;
	}
	
	@DeleteMapping("/processes/{id}")
	public void eliminarProcess(@PathVariable(name="id") int id) {
		processesServiceImpl.deleteProcess(id);
	}
	
}
