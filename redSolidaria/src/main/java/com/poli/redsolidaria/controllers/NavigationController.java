package com.poli.redsolidaria.controllers;

import com.poli.redsolidaria.models.User;
import com.poli.redsolidaria.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class NavigationController {
    private final UserService userService;

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("mainTitle", "¡Bienvenido a Red Solidaria!");
        return "/pages/home";
    }

    @GetMapping("/signup")
    public String signup(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("mainTitle", "Area de registro");
        return "/pages/signup";
    }

    @PostMapping("/signup")
    public String createUser(@ModelAttribute User newUser){
        userService.createUser(newUser);
        return "redirect:/pages/signup?success";
    }

    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("mainTitle", "Area de acceso");
        return "/pages/login";
    }
}
