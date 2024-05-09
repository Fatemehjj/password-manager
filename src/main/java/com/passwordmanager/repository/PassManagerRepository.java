package com.passwordmanager.repository;

import com.passwordmanager.model.PasswordManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PassManagerRepository extends JpaRepository<PasswordManager, Long> {
    Optional<PasswordManager> findByUsername(String userName);
}
