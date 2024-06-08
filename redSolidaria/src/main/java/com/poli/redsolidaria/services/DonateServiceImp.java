package com.poli.redsolidaria.services;

import com.poli.redsolidaria.models.Donative;
import com.poli.redsolidaria.repositories.DonateRepository;
import org.springframework.stereotype.Service;

@Service
public class DonateServiceImp implements DonateService{

    private final DonateRepository donateRepository;

    public DonateServiceImp(DonateRepository donateRepository){
        this.donateRepository = donateRepository;
    }
    @Override
    public void createDonative(Donative donative){
        donateRepository.save(donative);
    }


}
