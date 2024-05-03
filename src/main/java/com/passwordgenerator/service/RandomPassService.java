package com.passwordgenerator.service;

import com.google.common.hash.Hashing;
import com.passwordgenerator.model.PasswordManager;
import com.passwordgenerator.model.Passwords;
import com.passwordgenerator.repository.PassRepository;
import com.passwordgenerator.repository.RandomPasswordsRepository;
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
    PassRepository repository;
    @Autowired
    RandomPasswordsRepository passwordsRepository;
    public ResponseEntity<String> generateRandomPass(String username, String password) {
        Optional<PasswordManager> findUser = repository.findByUsername(username);
        if (findUser.isPresent() &&
                findUser.get().getMainPassword().equals(Hashing.sha256()
                .hashString(password, StandardCharsets.UTF_8)
                .toString())) {
            List<Passwords> passwords = new ArrayList<>();
            String generatePassword = getRandomPass();
            Passwords randomPass = new Passwords();
            randomPass.setPassword(generatePassword);
           passwords.add(randomPass);
            findUser.get().setPasswords(passwords);
          passwordsRepository.save(randomPass);

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
