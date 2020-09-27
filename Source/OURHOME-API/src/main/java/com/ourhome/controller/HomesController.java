package com.ourhome.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ourhome.dto.Homes;
import com.ourhome.service.HomesServiceImpl;

@RestController
@RequestMapping("/api")
public class HomesController {

	@Autowired
	HomesServiceImpl homesServiceImpl;
	
	
	@GetMapping("/homes")
	public List<Homes> listHomes(){
		return homesServiceImpl.listHomes();
	}
	
	@PostMapping("/homes")
	public Homes saveHomes(@RequestBody Homes home) {
		return homesServiceImpl.saveHomes(home);
	}
		
	@GetMapping("/homes/{id}")
	public Homes searchHome(@PathVariable(name="id") int id) {
		Homes home = new Homes();		
		home = homesServiceImpl.searchHome(id);
		
		return home;
	}
	
	@PutMapping("/homes/{id}")
	public Homes updateHome(@PathVariable(name="id") int id, @RequestBody Homes home) {
		Homes homeSelected = new Homes();
		Homes homeUpdated = new Homes();
		
		homeSelected = homesServiceImpl.searchHome(id);
		
		homeSelected.setUser(home.getUser());
		homeSelected.setUrlPhotos(home.getUrlPhotos());
		homeSelected.setDescription(home.getDescription());
		homeSelected.setPrice(home.getPrice());
		homeSelected.setNumBedrooms(home.getNumBedrooms());
		homeSelected.setNumBathroom(home.getNumBathroom());
		homeSelected.setCity(home.getCity());
		homeSelected.setDirection(home.getDirection());
		homeSelected.setMeters(home.getMeters());
		homeSelected.setFloors(home.getFloors());
		homeSelected.setAdditional(home.getAdditional());
		homeSelected.setCreatedAt(home.getCreatedAt());
		homeSelected.setUpdatedAt(home.getUpdatedAt());		
		
		return homeUpdated;
	}
	
	@DeleteMapping("/homes/{id}")
	public void deleteHome(@PathVariable(name="id") int id) {
		homesServiceImpl.deleteHome(id);
	}
	
}
