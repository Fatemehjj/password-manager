package com.passwordgenerator.repository;

import com.passwordgenerator.model.PasswordManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PassRepository extends JpaRepository<PasswordManager, Long> {
    Optional<PasswordManager> findByUsername(String userName);
}
