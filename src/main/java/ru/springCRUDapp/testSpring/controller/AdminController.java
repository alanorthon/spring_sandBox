package ru.springCRUDapp.testSpring.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.springCRUDapp.testSpring.model.Role;
import ru.springCRUDapp.testSpring.model.User;
import ru.springCRUDapp.testSpring.service.UserService;

import java.util.Collections;

@Controller
public class AdminController {
    private final UserService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public AdminController(UserService userService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @GetMapping(value = "/admin")
    public String getAllUsers(Model model) {
        model.addAttribute("userList", userService.allUsers());
        return "allusers";
    }

    @GetMapping(value = "/edituser/{id}")
    public String getUpdateUserPage(@PathVariable Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "edituser";
    }

    @PostMapping(value = "/edituser")
    public String updateUser(@RequestParam("id") String id,
                             @RequestParam String password,
                             @RequestParam String username,
                             @RequestParam String newPassword,
                             @RequestParam String email,
                             @RequestParam String role,
                             Model model) {
        Long tempId = Long.parseLong(id);
        User user;
        if (password.equals(bCryptPasswordEncoder.encode(newPassword))) {
            user = new User(tempId, username, email);
        } else {
            user = new User(tempId, username, newPassword, email);
        }
        userService.setRoleByName(user, role);
        userService.updateUser(user);
        model.addAttribute("message", "User successfully updated!");
        model.addAttribute("userList", userService.allUsers());
        return "allusers";
    }

    @GetMapping(value = "/adduser")
    public String getAddUserPage() {
        return "adduser";
    }

    @PostMapping(value = "/adduser")
    public String addUser(@ModelAttribute User user,
                          @RequestParam String role,
                          Model model) {
        if (userService.addUser(user, role)) {
            model.addAttribute("message", "User successfully added!");
        } else {
            model.addAttribute("message", "User with this username is already registered!");
        }
        model.addAttribute("userList", userService.allUsers());
        return "allusers";
    }

    @PostMapping(value = "/deleteuser/{id}")
    public String deleteUser(@PathVariable Long id, Model model) {
        model.addAttribute("message", "User successfully deleted!");
        userService.deleteUserById(id);
        model.addAttribute("userList", userService.allUsers());
        return "allusers";
    }
}
