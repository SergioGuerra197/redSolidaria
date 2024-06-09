package com.poli.redsolidaria.repositories;

import com.poli.redsolidaria.models.Donative;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DonativeRepository extends JpaRepository<Donative, Long> {
    List<Donative> findByTypeAndAvailableTrue(String type);

//    List<Donative> findByType(String type);

}
