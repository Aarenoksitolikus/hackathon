package ru.dev.bottled.cola.hackathon.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.dev.bottled.cola.hackathon.models.Chat;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChatsRepository extends JpaRepository<Chat, Long> {

    @Query("select chat from Chat chat where chat.senderId = :senderId and chat.recipientId = :recipientId " +
            "or chat.senderId = :recipientId and chat.recipientId = :senderId")
    Optional<Chat> findBySenderIdAndRecipientId(Long senderId, Long recipientId);

    @Query("select chat from Chat chat where chat.senderId = :userId or chat.recipientId = :userId")
    List<Chat> findAllByUserId(Long userId);
}
