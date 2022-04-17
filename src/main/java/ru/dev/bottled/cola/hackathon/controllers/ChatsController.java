package ru.dev.bottled.cola.hackathon.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.dev.bottled.cola.hackathon.models.Profile;
import ru.dev.bottled.cola.hackathon.security.details.UserDetailsImpl;
import ru.dev.bottled.cola.hackathon.services.templates.ChatsService;
import ru.dev.bottled.cola.hackathon.services.templates.UsersService;

@Controller
@RequestMapping("/chats")
public class ChatsController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    private ChatsService chatService;
    @GetMapping("/aralashu")
    public String getChatPage(Model model) {
        return "chat";
    }

    @GetMapping("/chat")
    public String getChatPage() {
        return "chat_page";
    }

    @GetMapping("/chats")
    public String getChatsPage(@AuthenticationPrincipal UserDetailsImpl userDetails, Model model) {
        var user = usersService.getUser(userDetails.getUsername());
        model.addAttribute("user", user);
        var profile = user.getProfile();
        model.addAttribute("profile", profile != null ? profile : new Profile());
        model.addAttribute("chats", chatService.getAllChatsByUserId(user.getId()));
        return "chat_page";
    }
}
