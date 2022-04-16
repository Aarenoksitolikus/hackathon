package ru.dev.bottled.cola.hackathon.services.realisations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dev.bottled.cola.hackathon.models.Chat;
import ru.dev.bottled.cola.hackathon.models.Message;
import ru.dev.bottled.cola.hackathon.repositories.ChatsRepository;
import ru.dev.bottled.cola.hackathon.repositories.MessagesRepository;
import ru.dev.bottled.cola.hackathon.repositories.UsersRepository;
import ru.dev.bottled.cola.hackathon.services.templates.ChatsService;

import java.util.List;

@Service
public class ChatsServiceImpl implements ChatsService {

    @Autowired
    private ChatsRepository chatsRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private MessagesRepository messagesRepository;

    @Override
    public Chat getOrCreateChatByUsersIds(Long senderId, Long recipientId, boolean createIfNotExist) {
        Chat chat = chatsRepository.findBySenderIdAndRecipientId(senderId, recipientId).orElse(null);
        if (chat == null) {
            if (createIfNotExist) {
                var sender = usersRepository.findById(senderId).get();
                var recipient = usersRepository.findById(recipientId).get();
                chat = Chat.builder()
                        .senderId(senderId)
                        .recipientId(recipientId)
                        .senderUsername(sender.getUsername())
                        .senderAvatar(sender.getAvatar())
                        .recipientUsername(recipient.getUsername())
                        .recipientAvatar(recipient.getAvatar())
                        .build();
                return chatsRepository.save(chat);
            }
        }
        return chat;
    }

    @Override
    public List<Chat> getAllChatsByUserId(Long userId) {
        return chatsRepository.findAllByUserId(userId);
    }

    @Override
    public Message saveNewMessage(Message message) {
        return messagesRepository.save(message);
    }

    @Override
    public Long countNewMessages(Long senderId, Long recipientId) {
        return messagesRepository.countBySenderIdAndRecipientIdAndState(senderId, recipientId, Message.State.RECEIVED);
    }

    @Override
    public List<Message> findMessages(Long senderId, Long recipientId) {
        var chat = chatsRepository.findBySenderIdAndRecipientId(senderId, recipientId);
        Long id = null;
        if (chat.isPresent()) {
            id = chat.get().getId();
        }
        return messagesRepository.findByChatId(id);
    }
}
