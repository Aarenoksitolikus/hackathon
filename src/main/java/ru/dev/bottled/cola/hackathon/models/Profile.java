package ru.dev.bottled.cola.hackathon.models;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "profiles")
public class Profile {

    @Id
    @Column(name = "user_id")
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    @Setter(AccessLevel.NONE)
    private User user;
    private String firstName;
    private String lastName;
    private String status;
    private String about;
    private Date birthday;

    @Enumerated(value = EnumType.STRING)
    private Sex sex;

    @ManyToMany
    @JoinTable(
            name = "profile prefs",
            joinColumns = @JoinColumn(name = "profile_id"),
            inverseJoinColumns = @JoinColumn(name = "preference_id"))
    List<Preference> preferences;

    @ManyToMany
    @JoinTable(
            name = "liked_services",
            joinColumns = @JoinColumn(name = "profile_id"),
            inverseJoinColumns = @JoinColumn(name = "service_id"))
    List<Service> likedServices;

    @ManyToMany
    @JoinTable(
            name = "liked_events",
            joinColumns = @JoinColumn(name = "profile_id"),
            inverseJoinColumns = @JoinColumn(name = "event_id"))
    List<Event> likedEvents;

    @ManyToMany
    @JoinTable(
            name = "activities",
            joinColumns = @JoinColumn(name = "profile_id"),
            inverseJoinColumns = @JoinColumn(name = "event_id"))
    List<Event> events;

    public void setUser(User user) {
        updateUser(user, true);
    }

    void updateUser(User user, boolean set) {
        this.user = user;
        if (user != null && set) {
            user.updateProfile(this, false);
        }
    }

    public Profile(User user) {
        this.user = user;
    }

    public enum Sex {
        MALE, FEMALE, UNDEFINED, DIFFERENT
    }
}
