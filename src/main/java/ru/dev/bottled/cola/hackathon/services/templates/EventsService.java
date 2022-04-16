package ru.dev.bottled.cola.hackathon.services.templates;

import org.springframework.stereotype.Service;
import ru.dev.bottled.cola.hackathon.models.Event;
import ru.dev.bottled.cola.hackathon.models.User;

import java.util.List;

@Service
public interface EventsService {
    List<Event> getAllTheMostPopular(Long userId);
    Event getById(Long id);
    Integer countLikes(Long eventId);
    Integer updateLikesCount(Long eventId);
    User getContactPerson(Long eventId);
}
