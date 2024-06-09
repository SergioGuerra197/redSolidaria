package com.poli.redsolidaria.controllers;

import com.poli.redsolidaria.models.Donative;
import com.poli.redsolidaria.models.User;
import com.poli.redsolidaria.services.DonativeService;
import com.poli.redsolidaria.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/donatives")
public class DonativesController {

    private final DonativeService donativeService;
    private final UserService userService;

    @Autowired
    public DonativesController(DonativeService donativeService, UserService userService) {
        this.donativeService = donativeService;
        this.userService = userService;
    }

    @GetMapping
    public String getDonatives(Model model){
        List <Donative> list = donativeService.getAvailableDonations();
        model.addAttribute("donatives", list);
        model.addAttribute("mainTitle", "¡Elije lo que mas necesites!");
        return "/pages/donatives";
    }

    @GetMapping("/filter")
    public String filterDonatives(@RequestParam("type") String type, Model model) {
        List<Donative> allDonatives = donativeService.findByType(type);
        List<Donative> filteredDonatives = new ArrayList<>();
        for (Donative donative : allDonatives){
            if (!donative.getIdUser().equals(String.valueOf(getUser().getId()))){
                filteredDonatives.add(donative);
            }
        }
        model.addAttribute("donatives", filteredDonatives);

        return "/pages/donatives";
    }

    private User getUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        return userService.findUserByEmail(email);
    }
}
