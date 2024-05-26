
package com.poli.redsolidaria.repositories;

import com.poli.redsolidaria.models.User;
import org.apache.logging.log4j.message.StringFormattedMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public Optional<User> findUserByEmail(String email);
}
