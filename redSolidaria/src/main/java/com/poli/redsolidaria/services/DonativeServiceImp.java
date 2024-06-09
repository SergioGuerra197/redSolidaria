package com.poli.redsolidaria.services;

import com.poli.redsolidaria.models.Donative;
import com.poli.redsolidaria.repositories.DonateRepository;
import com.poli.redsolidaria.repositories.DonativeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DonativeServiceImp implements DonativeService{

    private final DonativeRepository donativeRepository;

    public DonativeServiceImp(DonativeRepository donativeRepository){
        this.donativeRepository = donativeRepository;
    }

    @Override
    public List<Donative> getAvailableDonations(){
        return donativeRepository.findAll();
    }

    @Override
    public List<Donative> getAvailableFoodDonations() {
        return donativeRepository.findByTypeAndAvailableTrue("Alimento");
    }

    @Override
    public List<Donative> getAvailableSuppliesDonations() {
        return donativeRepository.findByTypeAndAvailableTrue("Util escolar");
    }

    @Override
    public List<Donative> getAvailableTimeDonations() {
        return donativeRepository.findByTypeAndAvailableTrue("Asesoria");
    }

    @Override
    public List<Donative> getAvailableOtherDonations() {
        return donativeRepository.findByTypeAndAvailableTrue("Varios");
    }
}
