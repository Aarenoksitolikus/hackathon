package ru.dev.bottled.cola.hackathon.dto;

import lombok.Data;

@Data
public class UserForm {
    private String username;
    private String password;
    private String email;
    private String passwordCheck;
}
