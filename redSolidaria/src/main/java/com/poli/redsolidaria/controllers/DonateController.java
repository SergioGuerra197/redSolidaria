package com.poli.redsolidaria.controllers;

import org.springframework.ui.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/donate")
public class DonateController {
    @GetMapping
    public String donate(Model model){
        model.addAttribute("mainTitle", "¡Empieza tu donacion!");
        return "/pages/donate";
    }
}
