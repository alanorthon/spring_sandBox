package ru.springCRUDapp.testSpring.service;

import ru.springCRUDapp.testSpring.model.User;

import java.util.List;

public interface UserService {
    List<User> allUsers();
    boolean addUser(User user);
    void updateUser(User user);
    User getUserById(Long id);
    void deleteUserById(Long id);
    User getUserByUsername(String login);
}