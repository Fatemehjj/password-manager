package com.passwordmanager.service;

import com.google.common.hash.Hashing;
import com.passwordmanager.model.PasswordManager;
import com.passwordmanager.repository.PassManagerRepository;
import org.passay.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.*;

@Service
public class RandomPassService {
    @Autowired
    PassManagerRepository repository;

    public ResponseEntity<String> generateRandomPass(String username, String password) {
        Optional<PasswordManager> findUser = repository.findByUsername(username);
        if (findUser.isPresent() &&
                findUser.get().getMainPassword().equals(Hashing.sha256()
                .hashString(password, StandardCharsets.UTF_8)
                .toString())) {

            String generatePassword = getRandomPass();
            PasswordManager passwordManager = new PasswordManager();
           List<String> currentPasswords = findUser.get().getPasswords();

           currentPasswords.add(generatePassword);

            passwordManager.setPasswords(currentPasswords);


            return new ResponseEntity<>("generated password is " + generatePassword, HttpStatus.CREATED);
        }
        return new ResponseEntity<>("username or password is not valid !",HttpStatus.BAD_REQUEST);
    }

    private static String getRandomPass() {
        List<CharacterRule> rules = Arrays.asList(
                new CharacterRule(EnglishCharacterData.UpperCase, 4),
                new CharacterRule(EnglishCharacterData.LowerCase, 5),
                new CharacterRule(EnglishCharacterData.Digit, 4),
                new CharacterRule(EnglishCharacterData.Special)
                //Whitespace exclusion is implicit as it's not included in the character sets
        );

        PasswordGenerator generator = new PasswordGenerator();
        String generatePassword = generator.generatePassword(16, rules);
        return generatePassword;
    }
}
