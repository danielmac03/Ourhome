package com.ourhome.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ourhome.dto.Homes;
import com.ourhome.service.HomesServiceImpl;

@RestController
@RequestMapping("/api/homes")
public class HomesController {

	@Autowired
	HomesServiceImpl homesServiceImpl;
	
	@GetMapping("/public")
	public List<Homes> listHomes(){
		return homesServiceImpl.listHomes();
	}

	@GetMapping("/public/{id}")
	public Homes getHome(@PathVariable(name="id") int id) {
		Homes home = new Homes();
		home = homesServiceImpl.getHome(id);

		return home;
	}

	@GetMapping("/user/{user_id}")
	public List<Homes> getHomesByUser(@PathVariable(name="user_id") int user_id) {
		return homesServiceImpl.getHomesByUser(user_id);
	}

	@GetMapping("/city/{city}")
	public List<Homes> getHomesByCity(@PathVariable(name="city") String city){
		return homesServiceImpl.getHomesByCity(city);
	}

	@PostMapping()
	public Homes saveHomes(@RequestBody Homes home) {
		return homesServiceImpl.saveHomes(home);
	}

	@PutMapping("/{id}")
	public Homes updateHome(@PathVariable(name="id") int id, @RequestBody Homes home) {
		Homes homeSelected = new Homes();
		Homes homeUpdated = new Homes();
		
		homeSelected = homesServiceImpl.getHome(id);
		
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

		homeUpdated = this.homesServiceImpl.updateHome(homeSelected);
		
		return homeUpdated;
	}
	
	@DeleteMapping("/{id}")
	public void deleteHome(@PathVariable(name="id") int id) {
		homesServiceImpl.deleteHome(id);
	}
	
}
