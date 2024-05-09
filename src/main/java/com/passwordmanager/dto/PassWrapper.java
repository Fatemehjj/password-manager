package com.passwordmanager.dto;

import lombok.Data;

import java.util.List;
@Data
public class PassWrapper {
    private String username;
    private List<String> passwords;
}
