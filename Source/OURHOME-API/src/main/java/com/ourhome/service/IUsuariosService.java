package com.ourhome.service;

import java.util.List;
import org.springframework.security.core.userdetails.UserDetails;

import com.ourhome.dto.Users;

public interface IUsuariosService {

	public List<Users> listUsers(); 
	
	public Users saveUser(Users user);	
	
	public Users searchUser(int id);
	
	public Users updateUser(Users user); 
	
	public void deleteUser(int id);

	public UserDetails loadUserByUsername(String correo);
	
}
