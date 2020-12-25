package com.ourhome.service;

import java.io.IOException;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetails;

import com.ourhome.dto.Users;
import org.springframework.web.multipart.MultipartFile;

public interface IUsersService {

	public List<Users> listUsers(); 
	
	public Users saveUser(Users user) throws IOException;

	public Users searchUser(int id);
	
	public Users searchUserByEmail(String email);
	
	public Users updateUser(Users user);

	public void deleteUser(int id);

}
