package ru.springCRUDapp.testSpring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.springCRUDapp.testSpring.DAO.UserDAO;
import ru.springCRUDapp.testSpring.model.User;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private UserDAO userDAO;

    @Autowired
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> allUsers() {
        return userDAO.allUsers();
    }

    @Override
    public boolean addUser(User user) {
        if (!userDAO.isExistingUser(user.getLogin())) {
            userDAO.addUser(user);
            return true;
        }
        return false;
    }

    @Override
    public void updateUser(User user) {
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
}
