package ru.dev.bottled.cola.hackathon.dto;

import lombok.Data;
import ru.dev.bottled.cola.hackathon.models.Profile;

import java.sql.Date;

@Data
public class ProfileInfo {
    private Long id;
    private String firstName;
    private String lastName;
    private String status;
    private String about;
    private Date birthday;
    private Profile.Sex sex;
}
