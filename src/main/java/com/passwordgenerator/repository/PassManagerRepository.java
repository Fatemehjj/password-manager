package com.passwordgenerator.repository;

import com.passwordgenerator.model.Passwords;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassManagerRepository extends JpaRepository<Passwords, Long> {
}
