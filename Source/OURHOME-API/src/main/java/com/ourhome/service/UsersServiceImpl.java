package com.ourhome.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static java.util.Collections.emptyList;
import org.springframework.security.core.userdetails.*;


import com.ourhome.dao.IUsersDAO;
import com.ourhome.dto.Users;

@Service
public class UsersServiceImpl implements IUsuariosService, UserDetailsService {

	@Autowired
	IUsersDAO iUsersDAO;
	
	@Override
	public List<Users> listUsers() {
		return iUsersDAO.findAll();
	}

	@Override
	public Users saveUser(Users user) {
		return iUsersDAO.save(user);
	}

	@Override
	public Users searchUser(int id) {
		return iUsersDAO.findById(id).get();
	}
	
	@Override
	public Users searchUserByEmail(String email) {
		return iUsersDAO.findByEmail(email);
	}

	@Override
	public Users updateUser(Users user) {
		return iUsersDAO.save(user);
	}

	@Override
	public void deleteUser(int id) {
		iUsersDAO.deleteById(id);
	}

	@Override
	public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
		Users usuario = iUsersDAO.findByEmail(correo);
		
		if (usuario == null) {
			throw new UsernameNotFoundException(correo);
		}
		
		return new User(usuario.getEmail(), usuario.getPassword(), emptyList());
	}


}
