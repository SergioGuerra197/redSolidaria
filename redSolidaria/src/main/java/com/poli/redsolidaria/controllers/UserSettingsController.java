package com.poli.redsolidaria.controllers;

import com.poli.redsolidaria.models.User;
import com.poli.redsolidaria.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/settings")
public class UserSettingsController {
    private final UserService userService;

    @Autowired
    public UserSettingsController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getForm(Model model){
        model.addAttribute("user", getUser());
        model.addAttribute("mainTitle", "¡Configura tu información!");
        return "/pages/settings";
    }

    @PostMapping
    public String updateUser(@ModelAttribute("user")User updateUser_){
        System.out.println(updateUser_.toString());
        if (updateUser_.getPassword() == null) {
            updateUser_.setPassword(getUser().getPassword());
        }
        userService.updateUser(updateUser_);
        return "redirect:/";
    }

    private User getUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        return userService.findUserByEmail(email);
    }
}
