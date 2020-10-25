package com.ourhome.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ourhome.dto.CustomTestsResponses;
import com.ourhome.service.CustomTestsResponsesServiceImpl;

@RestController
@RequestMapping("/api")
public class CustomTestsResponsesController {

	@Autowired
	CustomTestsResponsesServiceImpl customTestsResponsesServiceImpl;

	@GetMapping("/customTestResponses")
	public List<CustomTestsResponses> listCustomTestsResponses(){
		return customTestsResponsesServiceImpl.listCustomTestsResponses();
	}

	@PostMapping("/customTestResponses")
	public CustomTestsResponses saveCustomTestResponses(@RequestBody CustomTestsResponses customTestResponses) {
		return customTestsResponsesServiceImpl.saveCustomTestResponses(customTestResponses);
	}
	
	@GetMapping("/customTestResponses/{id}")
	public CustomTestsResponses searchCustomTestResponses(@PathVariable(name="id") int id) {
		CustomTestsResponses respuestasTestsPersonalizado = new CustomTestsResponses();		
		respuestasTestsPersonalizado = customTestsResponsesServiceImpl.searchCustomTestResponses(id);
		
		return respuestasTestsPersonalizado;
	}
	
	@PutMapping("/customTestResponses/{id}")
	public CustomTestsResponses actualizarRespuestaTestPersonalizado(@PathVariable(name="id") int id, @RequestBody CustomTestsResponses customTestResponses) {
		CustomTestsResponses customTestResponsesSelected = new CustomTestsResponses();
		CustomTestsResponses customTestResponsesUpdated = new CustomTestsResponses();
		
		customTestResponsesSelected = customTestsResponsesServiceImpl.searchCustomTestResponses(id);
				
		customTestResponsesSelected.setUser(customTestResponses.getUser());
		customTestResponsesSelected.setCustomTest(customTestResponses.getCustomTest());
		customTestResponsesSelected.setAnswers(customTestResponses.getAnswers());
		customTestResponsesSelected.setCompatibility(customTestResponses.getCompatibility());
		customTestResponsesSelected.setCreatedAt(customTestResponses.getCreatedAt());

		customTestResponsesUpdated = customTestsResponsesServiceImpl.updateCustomTestResponses(customTestResponsesSelected);
		
		return customTestResponsesUpdated;
	}
		
	@DeleteMapping("/customTestResponses/{id}")
	public void eliminarRespuestaTestPersonalizado(@PathVariable(name="id")int id) {
		customTestsResponsesServiceImpl.deleteCustomTestResponses(id);
	}
}
