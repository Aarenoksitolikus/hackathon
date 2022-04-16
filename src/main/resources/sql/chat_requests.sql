SELECT * FROM chats chat WHERE (chat.sender_id = ?1 AND chat.recipient_id = ?2) or (chat.sender_id = ?2 AND chat.recipient_id = ?1);

SELECT * FROM chats chat WHERE (chat.sender_id = ?1) or (chat.recipient_id = ?1);

