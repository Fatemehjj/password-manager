package com.passwordgenerator.controller;
import com.passwordgenerator.service.RandomPassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RandomPassController {
    @Autowired
    RandomPassService service;
    @GetMapping("random/password/{username}/{password}")
    public ResponseEntity<String> generateRandomPassword(@PathVariable String username, @PathVariable String password){
        return service.generateRandomPass(username, password);
    }
}
