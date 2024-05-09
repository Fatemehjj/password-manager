package com.passwordmanager.service;

import com.passwordmanager.dto.PassWrapper;
import com.passwordmanager.model.PasswordManager;
import com.passwordmanager.repository.PassManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GetAllPassService {
    @Autowired
    PassManagerRepository passManagerRepository;

    public ResponseEntity<PassWrapper> getAllPasswords(String username, String password) {
       Optional <PasswordManager> findUser = passManagerRepository.findByUsername(username);

        PassWrapper wrapper = new PassWrapper();
        List<String> getPasswords = findUser.get().getPasswords();
        List<String> updatedPass = new ArrayList<>();
       wrapper.setUsername(findUser.get().getUsername());

       for (String getPass : getPasswords){
           updatedPass.add(getPass);
       }

       wrapper.setPasswords(updatedPass);
       return new ResponseEntity<>(wrapper, HttpStatus.OK);
    }
}
