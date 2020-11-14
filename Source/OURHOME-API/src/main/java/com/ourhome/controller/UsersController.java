package com.ourhome.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.ourhome.dto.Users;
import com.ourhome.service.UsersServiceImpl;

@RestController
@RequestMapping("/api/users")
public class UsersController {

	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	UsersServiceImpl usersServiceImpl;

	public UsersController(BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@GetMapping()
	public List<Users> listUsers(){
		return usersServiceImpl.listUsers();
	}

	@GetMapping("/{id}")
	public Users searchUser(@PathVariable(name="id") int id) {
		Users user = new Users();		
		user = usersServiceImpl.searchUser(id);
		
		return user;
	}
	
	@GetMapping("/email/{email}")
	public Users searchUserByEmail(@PathVariable(name="email") String email) {
		Users user = new Users();		
		user = usersServiceImpl.searchUserByEmail(email);
		
		return user;
	}

	@PostMapping()
	public Users saveUser(@RequestBody Users user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		return usersServiceImpl.saveUser(user);
	}
	
	@PutMapping()
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
		userSelected.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userSelected.setRole(user.getRole());
		userSelected.setDefaultTestResponses(user.getDefaultTestResponses());
		userSelected.setShowPhone(user.isShowPhone());		

		userUpdated = usersServiceImpl.updateUser(userSelected);
		
		return userUpdated;	
	}
	
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable(name="id") int id) {
		usersServiceImpl.deleteUser(id);
	}
	
}
