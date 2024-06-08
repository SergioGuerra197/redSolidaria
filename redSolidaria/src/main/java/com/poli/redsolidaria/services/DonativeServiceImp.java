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
    public List<Donative> getAviableFoodDonations() {
        System.out.println("Llegó");
        return donativeRepository.findByTypeAndAvailableTrue("Alimento");
    }

    @Override
    public List<Donative> getAviableStudyDonatios() {
        return null;
    }

    @Override
    public List<Donative> getAviableTimeDonations() {
        return null;
    }

    @Override
    public List<Donative> getAviableOthersDonations() {
        return null;
    }
}
