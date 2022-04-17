package ru.dev.bottled.cola.hackathon.services.templates;

import org.springframework.stereotype.Service;
import ru.dev.bottled.cola.hackathon.models.Event;
import ru.dev.bottled.cola.hackathon.models.User;

import java.util.List;

public interface EventsService {
    List<Event> getAllTheMostPopular(Long userId);
    Event getById(Long id);
    Integer countLikes(Long eventId);
    Integer updateLikesCount(Long eventId, Long userId);
    User getContactPerson(Long eventId);
}
