package ru.dev.bottled.cola.hackathon.services.realisations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.dev.bottled.cola.hackathon.dto.ProfileInfo;
import ru.dev.bottled.cola.hackathon.dto.UserDto;
import ru.dev.bottled.cola.hackathon.dto.UserForm;
import ru.dev.bottled.cola.hackathon.exceptions.EntityAlreadyExistException;
import ru.dev.bottled.cola.hackathon.exceptions.EntityNotFoundException;
import ru.dev.bottled.cola.hackathon.models.Profile;
import ru.dev.bottled.cola.hackathon.models.User;
import ru.dev.bottled.cola.hackathon.repositories.ProfilesRepository;
import ru.dev.bottled.cola.hackathon.repositories.UsersRepository;
import ru.dev.bottled.cola.hackathon.services.templates.UsersService;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private ProfilesRepository profilesRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Value("${default.avatar}")
    private String defaultAvatar;

    @Value("${default.status}")
    private String defaultStatus;

    @Override
    public UserDto signUp(UserForm form) {
        if (usersRepository.findByUsername(form.getUsername()).isPresent()) {
            throw new EntityAlreadyExistException();
        }
        var newUser = User.builder()
                .username(form.getUsername())
                .email(form.getEmail())
                .hashPassword(passwordEncoder.encode(form.getPassword()))
                .avatar(defaultAvatar)
                .build();
        var user = usersRepository.save(newUser);
        Profile newProfile = Profile.builder()
                .user(user)
                .firstName("Исем")
                .lastName("Фамилия")
                .about("Биография")
                .birthday(Date.valueOf(LocalDate.now()))
                .status("Барыгызга да сәлам!")
                .sex(Profile.Sex.UNDEFINED)
                .build();

        user.setProfile(newProfile);
        return UserDto.from(usersRepository.save(user));
    }

    @Override
    public User getUser(String username) {
        return usersRepository.findByUsername(username).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public User getUser(Long id) {
        return usersRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void updateUser(User user) {
        if (usersRepository.findById(user.getId()).isPresent()) {
            usersRepository.save(user);
        }
    }

    @Override
    public void updateProfile(ProfileInfo info) {
        Optional<Profile> current = profilesRepository.findById(info.getId());
        if (current.isPresent()) {
            var profile = current.get();
            profile.setAbout(info.getAbout());
            profile.setFirstName(info.getFirstName());
            profile.setLastName(info.getLastName());
            profile.setAbout(info.getAbout());
            profile.setBirthday(info.getBirthday());
            profile.setStatus(info.getStatus());
            profile.setSex(info.getSex());
            profilesRepository.save(profile);
        }
    }

    @Override
    public void changeAvatar(Long id, String avatarUrl) {
        var current = getUser(id);
        current.setAvatar(avatarUrl);
        usersRepository.save(current);
    }
}
