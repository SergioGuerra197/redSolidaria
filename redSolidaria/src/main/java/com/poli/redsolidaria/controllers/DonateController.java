package com.poli.redsolidaria.controllers;

import com.poli.redsolidaria.models.Donative;
import com.poli.redsolidaria.models.User;
import com.poli.redsolidaria.services.DonateService;
import com.poli.redsolidaria.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;

@Controller
@AllArgsConstructor
@RequestMapping("/donate")
public class DonateController {

    private final UserService userService;
    private final DonateService donateService;

    @GetMapping
    public String getForm(Model model){
        model.addAttribute("donative", new Donative());
        model.addAttribute("mainTitle", "¡Empieza tu donacion!");
        return "/pages/donate";
    }

    @PostMapping
    public String addDonative(@ModelAttribute("donative")Donative newDonative){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        User user = userService.findUserByEmail(email);
        newDonative.setIdUser(String.valueOf(user.getId()));
        newDonative.setDonativeDate(LocalDateTime.now());
        newDonative.setAvailable(Boolean.TRUE);
        switch (newDonative.getType()) {
            case "Alimento" -> newDonative.setImage("food.png");
            case "Util escolar" -> newDonative.setImage("supplies.png");
            case "Asesoria" -> {
                newDonative.setImage("teaching.png");
                newDonative.setDonativeCondition("");
            }
            case "Varios" -> newDonative.setImage("other.png");
        }
        donateService.createDonative(newDonative);
        return "redirect:/donate?success";
    }
}
