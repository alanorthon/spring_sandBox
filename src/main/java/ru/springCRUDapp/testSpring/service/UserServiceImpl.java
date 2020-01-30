package ru.springCRUDapp.testSpring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.springCRUDapp.testSpring.DAO.UserDAO;
import ru.springCRUDapp.testSpring.model.Role;
import ru.springCRUDapp.testSpring.model.User;

import java.util.Collections;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public List<User> allUsers() {
        return userDAO.allUsers();
    }

    @Override
    public boolean addUser(User user) {
        if (!userDAO.isExistingUser(user.getUsername())) {
            user.setRoles(Collections.singleton(new Role(1L, "ROLE_USER")));
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            userDAO.addUser(user);
            return true;
        }
        return false;
    }

    @Override
    public void updateUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        userDAO.updateUser(user);
    }

    @Override
    public User getUserById(Long id) {
        return userDAO.getUserById(id);
    }

    @Override
    public void deleteUserById(Long id) {
        userDAO.deleteUserById(id);
    }

    @Override
    public User getUserByUsername(String login) {
        return userDAO.getUserByUsername(login);
    }

}