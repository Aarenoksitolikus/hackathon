package ru.dev.bottled.cola.hackathon.services.templates;

import org.springframework.stereotype.Service;
import ru.dev.bottled.cola.hackathon.models.Comment;
import ru.dev.bottled.cola.hackathon.models.Discussion;
import ru.dev.bottled.cola.hackathon.models.TatarService;

import java.util.List;

@Service
public interface TatarServicesService {
    List<TatarService> getAllTheMostPopular();
    TatarService getById(Long id);
    Integer countLikes(Long serviceId);
    Integer updateLikesCount(Long serviceId);
    Discussion startDiscussion(Long serviceId);
    Comment addNewComment(Comment comment);
}
