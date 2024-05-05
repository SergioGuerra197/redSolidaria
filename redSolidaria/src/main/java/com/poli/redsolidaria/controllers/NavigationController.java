package com.poli.redsolidaria.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavigationController {
    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("mainTitle", "¡Bienvenido a Red Solidaria!");
        return "/pages/home";
    }

    @GetMapping("/signup")
    public String signup(){
        return "/pages/signup";
    }
}
