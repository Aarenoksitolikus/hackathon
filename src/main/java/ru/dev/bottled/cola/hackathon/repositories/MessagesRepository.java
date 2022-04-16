package ru.dev.bottled.cola.hackathon.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dev.bottled.cola.hackathon.models.Message;

import java.util.List;

@Repository
public interface MessagesRepository  extends JpaRepository<Message, Long> {

    Long countBySenderIdAndRecipientIdAndState(Long senderId, Long recipientId, Message.State state);

    List<Message> findByChatId(Long chatId);
}
