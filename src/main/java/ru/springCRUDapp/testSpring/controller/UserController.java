package ru.springCRUDapp.testSpring.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.springCRUDapp.testSpring.model.User;
import ru.springCRUDapp.testSpring.service.UserService;

import java.util.List;


@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    @GetMapping(value = "/allusers")
    public ModelAndView allUsers() {
        List<User> allUsers = userService.allUsers();
        ModelAndView modelAndView = new ModelAndView("allusers");
        modelAndView.addObject("allUsers", allUsers);
        return modelAndView;
    }

    @GetMapping(value = "/edituser/{id}")
    public ModelAndView editPage(@PathVariable Long id) {
        User user = userService.getUserById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("edituser");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @PostMapping(value = "/edituser")
    public ModelAndView editUser(@ModelAttribute("user") User user) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/allusers");
        userService.updateUser(user);
        return modelAndView;
    }

    @GetMapping(value = "/adduser")
    public ModelAndView addPage() {
        return new ModelAndView("/adduser");
    }

    @PostMapping(value = "/adduser")
    public ModelAndView addUser(@ModelAttribute("user") User user) {
        ModelAndView modelAndView = new ModelAndView("redirect:/allusers");
        modelAndView.setViewName("redirect:/allusers");
        userService.addUser(user);
        return modelAndView;
    }

    @PostMapping(value="/deleteuser/{id}")
    public ModelAndView deleteFilm(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/allusers");
        userService.deleteUserById(id);
        return modelAndView;
    }
}
