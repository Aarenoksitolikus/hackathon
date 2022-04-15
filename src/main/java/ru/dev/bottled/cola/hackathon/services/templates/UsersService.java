package ru.dev.bottled.cola.hackathon.services.templates;

import org.springframework.stereotype.Service;
import ru.dev.bottled.cola.hackathon.dto.ProfileInfo;
import ru.dev.bottled.cola.hackathon.dto.UserDto;
import ru.dev.bottled.cola.hackathon.dto.UserForm;
import ru.dev.bottled.cola.hackathon.models.User;

@Service
public interface UsersService {
    UserDto signUp(UserForm form);
    User getUser(String username);

    void updateUser(User user);
    void updateProfile(ProfileInfo profileInfo);
}
