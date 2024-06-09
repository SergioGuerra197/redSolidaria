package com.poli.redsolidaria.services;

import com.poli.redsolidaria.models.Donative;

import java.util.List;

public interface DonativeService {

    List<Donative> getAvailableDonations();

    List<Donative> findByType(String type);
}
