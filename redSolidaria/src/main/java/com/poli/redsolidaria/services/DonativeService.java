package com.poli.redsolidaria.services;

import com.poli.redsolidaria.models.Donative;

import java.util.List;
import java.util.Optional;

public interface DonativeService {

    List<Donative> getAvailableDonations();

    Optional<Donative> findById(Long id);

    List<Donative> findByType(String type);
}
