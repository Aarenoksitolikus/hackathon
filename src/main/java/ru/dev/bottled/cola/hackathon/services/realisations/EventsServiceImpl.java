package ru.dev.bottled.cola.hackathon.services.realisations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dev.bottled.cola.hackathon.exceptions.EntityNotFoundException;
import ru.dev.bottled.cola.hackathon.models.Event;
import ru.dev.bottled.cola.hackathon.models.User;
import ru.dev.bottled.cola.hackathon.repositories.EventsRepository;
import ru.dev.bottled.cola.hackathon.repositories.ServicesRepository;
import ru.dev.bottled.cola.hackathon.repositories.UsersRepository;
import ru.dev.bottled.cola.hackathon.services.templates.EventsService;

import java.util.List;

@Service
public class EventsServiceImpl implements EventsService {

    @Autowired
    private EventsRepository eventsRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public List<Event> getAllTheMostPopular(Long userId) {
        return null;
    }

    @Override
    public Event getById(Long id) {
        return eventsRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Integer countLikes(Long eventId) {
        return null;
    }

    @Override
    public Integer updateLikesCount(Long eventId) {
        return null;
    }

    @Override
    public User getContactPerson(Long eventId) {
        return null;
    }
}
