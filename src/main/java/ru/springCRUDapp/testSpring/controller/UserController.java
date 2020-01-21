package ru.springCRUDapp.testSpring.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.springCRUDapp.testSpring.model.User;
import ru.springCRUDapp.testSpring.service.UserService;

@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String getIndexPage() {
        return "index";
    }

    @GetMapping(value = "/allusers")
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
    public String updateUser(@ModelAttribute User user, Model model) {
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
    public String addUser(@ModelAttribute User user, Model model) {
        if (userService.addUser(user)) {
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
