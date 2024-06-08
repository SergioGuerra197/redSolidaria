package com.poli.redsolidaria.controllers;

import com.poli.redsolidaria.models.Donative;
import com.poli.redsolidaria.models.User;
import com.poli.redsolidaria.services.DonativeService;
import com.poli.redsolidaria.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/donatives")
public class DonativesController {

    private final DonativeService donativeService;

    private final UserService userService;
    @Autowired
    public DonativesController(DonativeService donativeService, UserService userService) {
        this.donativeService = donativeService;
        this.userService = userService;
    }

    @GetMapping("/filter/food")
    public List<Donative> getAviableFoodDonations(){
        System.out.println("haosndjaskjasdjkabsdbuiabsdb");
        List <Donative> list = donativeService.getAviableFoodDonations();
        System.out.println(list);
        return list.stream()
                .filter(donative -> !donative.getIdUser().equals(getUser().getId()))
                .collect(Collectors.toList());
    }

    private User getUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        return userService.findUserByEmail(email);
    }
}
