package ru.dev.bottled.cola.hackathon.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.dev.bottled.cola.hackathon.models.Message;
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

    @GetMapping
    public String getChatsPage(@AuthenticationPrincipal UserDetailsImpl userDetails, Model model) {
        var user = usersService.getUser(userDetails.getUsername());
        model.addAttribute("user", user);
        var profile = user.getProfile();
        model.addAttribute("profile", profile != null ? profile : new Profile());
        model.addAttribute("chats", chatService.getAllChatsByUserId(user.getId()));
        return "chat_page";
    }

    @MessageMapping("/chat")
    public void processMessage(@Payload Message message) {
        var chat = chatService.getOrCreateChatByUsersIds(message.getSenderId(),
                message.getRecipientId(),
                true);
        message.setChat(chat);
        message = chatService.saveNewMessage(message);

        messagingTemplate.convertAndSendToUser(message.getRecipientId().toString(), "/queue/messages",
                Message.builder()
                        .id(message.getId())
                        .senderId(message.getSenderId())
                        .senderUsername(message.getSenderUsername())
                        .recipientId(message.getRecipientId())
                        .recipientUsername(message.getRecipientUsername())
                        .content(message.getContent())
                        .sendDate(message.getSendDate())
                        .state(message.getState())
                        .build()
        );
    }

    @GetMapping("/get/chat/{sender-id}/{recipient-id}")
    public String getUserProfile(@AuthenticationPrincipal UserDetailsImpl userDetails,
                                 @PathVariable("sender-id") Long senderId,
                                 @PathVariable("recipient-id") Long recipientId,
                                 Model model) {
        var messages = chatService.findMessages(senderId, recipientId);
        var otherUserId = senderId.equals(userDetails.getUser().getId()) ? recipientId : senderId;
        model.addAttribute("currentUser", usersService.getUser(userDetails.getUsername()));
        model.addAttribute("otherUserId", otherUserId);
        model.addAttribute("otherUser", usersService.getUser(otherUserId));
        model.addAttribute("messages", messages);
        return "chat_partial";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/get/chat/{username}")
    public String getChat(@AuthenticationPrincipal UserDetailsImpl userDetails,
                          @PathVariable("username") String username, Model model) {
        var user = usersService.getUser(username);
        Long userId;
        if (user != null) {
            userId = user.getId();
            chatService.getOrCreateChatByUsersIds(userDetails.getUser().getId(), userId, true);
            var messages = chatService.findMessages(userDetails.getUser().getId(), userId);
            model.addAttribute("currentUser", userDetails.getUser());
            model.addAttribute("otherUserId", userId);
            model.addAttribute("otherUser", user);
            model.addAttribute("messages", messages);
        } else {
            model.addAttribute("nullable", null);
        }
        return "chat_partial";
    }
}
