package com.ourhome.service;

import com.ourhome.dto.Users;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.io.IOException;
import java.util.List;

public interface IUsersService extends UserDetailsService {

    public List<Users> listUsers();

    public Users saveUser(Users user) throws IOException;

    public Users searchUser(int id);

    public Users searchUserByEmail(String email);

    public Users updateUser(Users user);

    public void deleteUser(int id);

    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException;

}
