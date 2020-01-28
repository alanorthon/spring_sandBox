package ru.springCRUDapp.testSpring.DAO;

import ru.springCRUDapp.testSpring.model.User;

import java.util.List;

public interface UserDAO  {
    List<User> allUsers();
    void addUser(User user);
    void updateUser(User user);
    User getUserById(Long id);
    User getUserByLogin(String login);
    void deleteUserById(Long id);
    boolean isExistingUser(String login);
}
