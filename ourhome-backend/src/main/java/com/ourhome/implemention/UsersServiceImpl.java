package com.ourhome.implemention;

import com.ourhome.dao.IUsersDAO;
import com.ourhome.dto.Users;
import com.ourhome.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static java.util.Collections.emptyList;

@Service
public class UsersServiceImpl implements IUsersService, UserDetailsService {

    private final Path root = Paths.get("uploads/profile-pictures");

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

        return new User(user.getEmail(), user.getPassword(), emptyList());
    }


}
