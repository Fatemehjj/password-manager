package com.passwordmanager.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Entity
@Setter
@Getter
@ToString
@EqualsAndHashCode
@Table(name = "password-manager")
/*
this entity contains username and password, also it has
list of generated user passwords
 */
public class PasswordManager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ElementCollection
    private List<String> passwords;
    //@Size(min = 3, max = 20)
    private String username;
    @Column(name = "main_password")
    //@Size(min = 8, max = 18)
    private String mainPassword;
}
