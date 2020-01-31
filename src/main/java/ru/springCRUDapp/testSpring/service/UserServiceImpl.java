package ru.springCRUDapp.testSpring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.springCRUDapp.testSpring.DAO.UserDAO;
import ru.springCRUDapp.testSpring.model.Role;
import ru.springCRUDapp.testSpring.model.User;

import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(UserDAO userDAO, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userDAO = userDAO;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public List<User> allUsers() {
        return userDAO.allUsers();
    }

    @Override
    @Transactional
    public boolean addUser(User user, String role) {
        if (!userDAO.isExistingUser(user.getUsername())) {
            setRoleByName(user, role);
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            userDAO.addUser(user);
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        userDAO.updateUser(user);
    }

    @Override
    public User getUserById(Long id) {
        return userDAO.getUserById(id);
    }

    @Override
    @Transactional
    public void deleteUserById(Long id) {
        userDAO.deleteUserById(id);
    }

    @Override
    public User getUserByUsername(String login) {
        return userDAO.getUserByUsername(login);
    }

    @Override
    public void setRoleByName(User user, String role) {
        if (role.equalsIgnoreCase("admin")) {
            user.setRoles(Collections.singleton(new Role(2L, "ROLE_ADMIN")));
        } else {
            user.setRoles(Collections.singleton(new Role(1L, "ROLE_USER")));
        }
    }
}