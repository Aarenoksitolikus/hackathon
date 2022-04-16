package ru.dev.bottled.cola.hackathon.models;

import lombok.*;

import java.sql.Date;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(mappedBy = "events")
    List<Organization> organizers;

    @ManyToMany
    @JoinTable(
            name = "event_prefs",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "profile_id"))
    List<Preference> preferences;

    @ManyToMany(mappedBy = "likedEvents")
    List<Profile> likes;

    private String name;
    private Date date;
    private String description;
    private String link;
    //TODO: add geo-location

    public int getLikesQuantity() {
        //TODO: реализовать функцию получения рейтинга
        return 0;
    }
}
