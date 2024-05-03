package com.passwordgenerator.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@ToString
@EqualsAndHashCode
@Table(name = "password-manager")
public class PasswordManager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToMany
    private List<Passwords> passwords;
    private String username;
    @Column(name = "main_password")
    private String mainPassword;
}
