package com.poli.redsolidaria.controllers;

import com.poli.redsolidaria.models.User;
import com.poli.redsolidaria.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/signup")
public class SignupController {

    private final UserService userService;

    @Autowired
    public SignupController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("user")
    public User getUser() {
        return new User();
    }

    @GetMapping
    public String getForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("mainTitle", "Area de registro");
        return "/pages/signup";
    }

    @PostMapping
    public String addUser(@ModelAttribute("user") User newUser) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(newUser.getPassword());
        newUser.setPassword(encodedPassword);
        userService.createUser(newUser);
        return "redirect:/signup?success";
    }
}