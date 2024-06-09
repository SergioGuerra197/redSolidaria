package com.poli.redsolidaria.services;

import com.poli.redsolidaria.models.Donative;
import com.poli.redsolidaria.models.User;
import com.poli.redsolidaria.repositories.DonateRepository;
import com.poli.redsolidaria.repositories.DonativeRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DonativeServiceImp implements DonativeService{

    private final DonativeRepository donativeRepository;
    private final UserService userService;

    public DonativeServiceImp(DonativeRepository donativeRepository, UserService userService){
        this.donativeRepository = donativeRepository;
        this.userService = userService;
    }

    @Override
    public List<Donative> getAvailableDonations(){
        return donativeRepository.findAll();
    }

   @Override
    public List<Donative> findByType(String type){
        return donativeRepository.findByTypeAndAvailableTrue(type);
   }

    private User getUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        return userService.findUserByEmail(email);
    }
}
