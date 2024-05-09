package com.poli.redsolidaria.controllers;

import com.poli.redsolidaria.models.User;
import com.poli.redsolidaria.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping("/signup")
public class SignupController {

    private UserService userService;

    @ModelAttribute("user")
    public User getUser() {
        return new User();
    }

    @GetMapping
    public String getForm(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("mainTitle", "Area de registro");
        return "/pages/signup";
    }

    @PostMapping
    public String addUser(@ModelAttribute("user") User newUser){
        userService.createUser(newUser);
        return "redirect:/signup?success";
    }
}