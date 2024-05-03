package com.passwordgenerator.controller;

import com.passwordgenerator.service.AddUserPassManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddUserPassManagerController {
    @Autowired
    AddUserPassManagerService userPassManagerService;
    @PostMapping("add/{username}/{password}")
    public ResponseEntity<String> addUserManager(@PathVariable String username, @PathVariable String password){
        return userPassManagerService.addUserManager(username, password);
    }

}
