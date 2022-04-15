package ru.dev.bottled.cola.hackathon.services.realisations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dev.bottled.cola.hackathon.dto.ProfileInfo;
import ru.dev.bottled.cola.hackathon.dto.UserDto;
import ru.dev.bottled.cola.hackathon.dto.UserForm;
import ru.dev.bottled.cola.hackathon.models.User;
import ru.dev.bottled.cola.hackathon.repositories.UsersRepository;
import ru.dev.bottled.cola.hackathon.services.templates.UsersService;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDto signUp(UserForm form) {
        return null;
    }

    @Override
    public User getUser(String username) {
        return null;
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void updateProfile(ProfileInfo profileInfo) {

    }
}
