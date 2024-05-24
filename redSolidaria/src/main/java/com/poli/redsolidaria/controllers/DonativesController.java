package com.poli.redsolidaria.controllers;

import org.springframework.ui.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/donatives")
public class DonativesController {
    @GetMapping
    public String donatives(Model model){
        return "/pages/donatives";
    }
}
