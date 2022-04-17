package ru.dev.bottled.cola.hackathon.services.templates;

import org.springframework.stereotype.Service;
import ru.dev.bottled.cola.hackathon.models.Chat;
import ru.dev.bottled.cola.hackathon.models.Message;

import java.util.List;

public interface ChatsService {

    Chat getOrCreateChatByUsersIds(Long senderId, Long recipientId, boolean createIfNotExist);
    List<Chat> getAllChatsByUserId(Long userId);
    Message saveNewMessage(Message message);
    Long countNewMessages(Long senderId, Long recipientId);
    List<Message> findMessages(Long senderId, Long recipientId);
}
