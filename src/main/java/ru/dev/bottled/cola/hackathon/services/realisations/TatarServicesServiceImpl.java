package ru.dev.bottled.cola.hackathon.services.realisations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dev.bottled.cola.hackathon.models.Comment;
import ru.dev.bottled.cola.hackathon.models.TatarService;
import ru.dev.bottled.cola.hackathon.repositories.CommentsRepository;
import ru.dev.bottled.cola.hackathon.repositories.TatarServicesRepository;
import ru.dev.bottled.cola.hackathon.services.templates.TatarServicesService;

import java.util.List;

@Service
public class TatarServicesServiceImpl implements TatarServicesService {

    @Autowired
    private TatarServicesRepository servicesRepository;

    @Autowired
    private CommentsRepository commentsRepository;

    @Override
    public List<TatarService> getAllTheMostPopular() {
        return null;
    }

    @Override
    public TatarService getById(Long id) {
        return null;
    }

    @Override
    public Integer countLikes(Long serviceId) {
        return null;
    }

    @Override
    public Integer updateLikesCount(Long serviceId) {
        return null;
    }

    @Override
    public Comment addNewComment(Comment comment) {
        return null;
    }
}
