package com.ourhome.service;

import java.io.IOException;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetails;

import com.ourhome.dto.Users;
import org.springframework.web.multipart.MultipartFile;

public interface IUsuariosService {

	public List<Users> listUsers(); 
	
	public Users saveUser(Users user, MultipartFile profilePicture) throws IOException;
	
	public Users searchUser(int id);
	
	public Users searchUserByEmail(String email);
	
	public Users updateUser(Users user); 
	
	public void deleteUser(int id);

	public UserDetails loadUserByUsername(String correo);
	
}
