package com.poli.redsolidaria.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/")
public class HomeController {
    @GetMapping
    public String home(Model model){
        model.addAttribute("mainTitle", "¡Bienvenido a Red Solidaria!");
        return "/pages/home";
    }
}
