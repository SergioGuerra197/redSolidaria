package com.poli.redsolidaria.controllers;

import com.poli.redsolidaria.models.Donative;
import org.springframework.ui.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/donate")
public class DonateController {
    @GetMapping
    public String getForm(Model model){
        model.addAttribute("donative", new Donative());
        model.addAttribute("mainTitle", "¡Empieza tu donacion!");
        return "/pages/donate";
    }

    @PostMapping
    public String addDonative(@ModelAttribute("donative")Donative newDonative){
        return "redirect:/donative?success";
    }
}
