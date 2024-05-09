package com.passwordmanager.controller;

import com.passwordmanager.dto.PassWrapper;
import com.passwordmanager.service.GetAllPassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetPassController {
    @Autowired
    GetAllPassService allPassS;
    @GetMapping("get/passwords/{username}/{password}")
    public ResponseEntity<PassWrapper> getPasswords(@PathVariable String username, @PathVariable String password){
        return allPassS.getAllPasswords(username, password);
    }
}
