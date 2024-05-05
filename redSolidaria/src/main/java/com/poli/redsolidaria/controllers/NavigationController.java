package com.poli.redsolidaria.controllers;

import com.poli.redsolidaria.models.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class NavigationController {

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

    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("mainTitle", "Area de acceso");
        return "/pages/login";
    }
}
