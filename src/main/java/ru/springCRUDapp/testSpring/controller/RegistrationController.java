package ru.springCRUDapp.testSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.springCRUDapp.testSpring.model.User;
import ru.springCRUDapp.testSpring.service.UserService;

import javax.validation.Valid;

@Controller
public class RegistrationController {
    private final UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@ModelAttribute("userForm") @Valid User userForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "registration";
        }
        if (!userForm.getPassword().equals(userForm.getPasswordConfirm())) {
            model.addAttribute("passwordError", "You entered two different passwords. Please try again.");
            return "registration";
        }
        if (!userService.addUser(userForm, "user")) {
            model.addAttribute("loginError", "User with this Login already registered");
            return "registration";
        }

        return "redirect:/";
    }
}
