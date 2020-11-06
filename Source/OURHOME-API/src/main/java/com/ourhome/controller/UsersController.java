package com.ourhome.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.ourhome.dto.Users;
import com.ourhome.service.UsersServiceImpl;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class UsersController {

	@Autowired
	UsersServiceImpl usersServiceImpl;
	
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public UsersController(BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@GetMapping("/users")
	public List<Users> listUsers(){
		return usersServiceImpl.listUsers();
	}
	
	@PostMapping("/users")
	public Users saveUser(@RequestBody Users user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		return usersServiceImpl.saveUser(user);
	}
	
	@GetMapping("/users/{id}")
	public Users searchUser(@PathVariable(name="id") int id) {
		Users user = new Users();		
		user = usersServiceImpl.searchUser(id);
		
		return user;
	}
	
	@GetMapping("/users/email/{email}")
	public Users searchUserByEmail(@PathVariable(name="email") String email) {
		Users user = new Users();		
		user = usersServiceImpl.searchUserByEmail(email);
		
		return user;
	}
	
	@PutMapping("/users")
	public Users updateUser(@RequestBody Users user) {
		Users userSelected = new Users();
		Users userUpdated = new Users();
		
		userSelected = usersServiceImpl.searchUser(user.getId());

		userSelected.setName(user.getName());
		userSelected.setSurnames(user.getSurnames());
		userSelected.setUrlPhoto(user.getUrlPhoto());
		userSelected.setDescription(user.getDescription());
		userSelected.setAge(user.getAge());
		userSelected.setPhone(user.getPhone());
		userSelected.setEmail(user.getEmail());
		userSelected.setPassword(user.getPassword());
		userSelected.setRole(user.getRole());
		userSelected.setDefaultTestResponses(user.getDefaultTestResponses());
		userSelected.setShowPhone(user.isShowPhone());		
		userSelected.setCreatedAt(user.getCreatedAt());
		userSelected.setUpdatedAt(user.getUpdatedAt());
		userSelected.setHomes(user.getHomes());
		userSelected.setProcess(user.getProcess());
		userSelected.setCustomTest(user.getCustomTest());

		userUpdated = usersServiceImpl.updateUser(userSelected);
		
		return userUpdated;	
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable(name="id") int id) {
		usersServiceImpl.deleteUser(id);
	}
	
}
