package com.poli.redsolidaria.services;

import com.poli.redsolidaria.models.Donative;

import java.util.List;

public interface DonativeService {

    List<Donative> getAviableFoodDonations();

    List<Donative> getAviableStudyDonatios();

    List<Donative>  getAviableTimeDonations();

    List<Donative> getAviableOthersDonations();

}
