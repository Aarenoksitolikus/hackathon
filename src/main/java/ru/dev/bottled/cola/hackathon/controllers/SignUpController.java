package ru.dev.bottled.cola.hackathon.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.dev.bottled.cola.hackathon.dto.UserForm;
import ru.dev.bottled.cola.hackathon.services.templates.UsersService;

@Controller
public class SignUpController {
    @Autowired
    private UsersService usersService;

    @GetMapping("/signup")
    public String getSignUpPage(Model model) {
        model.addAttribute("userForm", new UserForm());
        return "register";
    }

    @PostMapping("/signup")
    public String signUp(UserForm form, Model model) {
        usersService.signUp(form);
        model.addAttribute("username", form.getUsername());
        return "redirect:/confirm";
    }

    @GetMapping("/confirm")
    public String getConfirmPage() {
        return "confirm_page";
    }
}
