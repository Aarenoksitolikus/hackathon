package ru.dev.bottled.cola.hackathon.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chats")
public class ChatsController {
    @GetMapping
    public String getChatPage(Model model) {
        return "chat";
    }
}
