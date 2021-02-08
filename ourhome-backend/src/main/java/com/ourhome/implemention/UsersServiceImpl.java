package com.ourhome.implemention;

import com.ourhome.dao.IUsersDAO;
import com.ourhome.dto.Users;
import com.ourhome.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class UsersServiceImpl implements IUsersService {

    @Autowired
    IUsersDAO iUsersDAO;

    @Override
    public Users saveUser(Users user) throws IOException {
        return iUsersDAO.save(user);
    }

    @Override
    public List<Users> listUsers() {
        return iUsersDAO.findAll();
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
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Users user = iUsersDAO.findByEmail(email);

        if (user == null) {
            throw new UsernameNotFoundException(email);
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole()));

        return new User(user.getEmail(), user.getPassword(), authorities);
    }


}
