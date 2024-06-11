package com.poli.redsolidaria.controllers;

import com.poli.redsolidaria.models.Donative;
import com.poli.redsolidaria.models.User;
import com.poli.redsolidaria.services.DonativeService;
import com.poli.redsolidaria.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

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
        model.addAttribute("donatives", filterDonative(list));
        model.addAttribute("mainTitle", "¡Elije lo que mas necesites!");
        return "/pages/donatives";
    }

    @GetMapping("/")
    @ResponseBody // Añade esta anotación
    public ResponseEntity<?> filterDonativeById(@RequestParam("id") Long id) {
        Optional<Donative> donative = donativeService.findById(id);
        if (donative.isPresent()) {
            User user = userService.findUserById(Long.parseLong(donative.get().getIdUser()));
            Map<String, Object> responseBody = new HashMap<>();
            responseBody.put("donative", donative.get());
            responseBody.put("user", user);
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(responseBody);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/filter")
    public String filterDonativesByType(@RequestParam("type") String type, Model model) {
        List<Donative> allDonatives = donativeService.findByType(type);
        model.addAttribute("donatives", filterDonative(allDonatives));

        return "/pages/donatives";
    }

    //Private methods
    private User getUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        return userService.findUserByEmail(email);
    }

    private List<Donative> filterDonative(List<Donative> donatives){
        List<Donative> filteredDonatives = new ArrayList<>();
        for (Donative donative : donatives) {
            if (!donative.getIdUser().equals(String.valueOf(getUser().getId()))) {
                filteredDonatives.add(donative);
            }
        }
        return filteredDonatives;
    }
}
