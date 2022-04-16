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

    @ManyToMany
    @JoinTable(
            name = "event_prof",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "profile_id"))
    List<Profile> organizers;

    private String name;
    private Date date;
    private String info;
    public int getLikesQuantity() {
        //TODO: реализовать функцию получения рейтинга
        return 0;
    }
}
