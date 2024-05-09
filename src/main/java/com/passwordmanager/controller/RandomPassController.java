package com.passwordmanager.controller;
import com.passwordmanager.service.RandomPassService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RandomPassController {
    @Autowired
    RandomPassService service;
    @PutMapping("random/password/{username}/{password}")
    @Transactional
    public ResponseEntity<String> generateRandomPassword(@PathVariable String username, @PathVariable String password){
        return service.generateRandomPass(username, password);
    }
}
