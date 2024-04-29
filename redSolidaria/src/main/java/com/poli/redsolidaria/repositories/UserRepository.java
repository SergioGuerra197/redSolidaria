package com.poli.redsolidaria.repositories;

import com.poli.redsolidaria.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
