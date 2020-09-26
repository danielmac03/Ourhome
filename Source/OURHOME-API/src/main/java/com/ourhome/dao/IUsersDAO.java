package com.ourhome.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ourhome.dto.Users;

public interface IUsersDAO extends JpaRepository<Users, Integer>{

	Users findByEmail(String email);
	
}
