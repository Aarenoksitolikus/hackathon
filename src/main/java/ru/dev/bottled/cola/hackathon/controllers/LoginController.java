package ru.dev.bottled.cola.hackathon.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String getSignInPage() {
        return "login";
    }
}
