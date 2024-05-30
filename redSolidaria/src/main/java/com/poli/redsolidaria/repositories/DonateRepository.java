package com.poli.redsolidaria.repositories;

import com.poli.redsolidaria.models.Donative;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonateRepository extends JpaRepository<Donative, Long> {
}
