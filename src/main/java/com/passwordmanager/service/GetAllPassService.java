package com.passwordmanager.service;

import com.google.common.hash.Hashing;
import com.passwordmanager.dto.PassWrapper;
import com.passwordmanager.model.PasswordManager;
import com.passwordmanager.repository.PassManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GetAllPassService {
    @Autowired
    PassManagerRepository passManagerRepository;

    public ResponseEntity<PassWrapper> getAllPasswords(String username, String password) {
        Optional<PasswordManager> findUser = passManagerRepository.findByUsername(username);
        if (findUser.isPresent() &&
                findUser.get().getMainPassword().equals(Hashing.sha256()
                        .hashString(password, StandardCharsets.UTF_8)
                        .toString())) {

            PassWrapper wrapper = new PassWrapper();
            List<String> getPasswords = findUser.get().getPasswords();
            List<String> updatedPass = new ArrayList<>();
            wrapper.setUsername(findUser.get().getUsername());

            updatedPass.addAll(getPasswords);

            wrapper.setPasswords(updatedPass);
            return new ResponseEntity<>(wrapper, HttpStatus.OK);
        }
        return new ResponseEntity<>(new PassWrapper("user has not been found",new ArrayList<>()), HttpStatus.BAD_REQUEST);
    }
}
