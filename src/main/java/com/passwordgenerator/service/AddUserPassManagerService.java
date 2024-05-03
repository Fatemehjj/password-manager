package com.passwordgenerator.service;

import com.google.common.hash.Hashing;
import com.passwordgenerator.model.PasswordManager;
import com.passwordgenerator.repository.PassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Service
public class AddUserPassManagerService {
    @Autowired
    PassRepository repository;
    public ResponseEntity<String> addUserManager(String username, String password) {
        if (repository.findByUsername(username).isPresent()) return new ResponseEntity<>("this username is already exist !",HttpStatus.BAD_REQUEST);
        else {
            PasswordManager passwordManager = new PasswordManager();
            String sha256hex = Hashing.sha256()
                    .hashString(password, StandardCharsets.UTF_8)
                    .toString();
            passwordManager.setMainPassword(sha256hex);
            passwordManager.setUsername(username);

            repository.save(passwordManager);

            return new ResponseEntity<>("user has been added successfully", HttpStatus.CREATED);
        }
    }
}
