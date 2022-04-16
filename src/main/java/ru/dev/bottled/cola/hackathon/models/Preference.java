package ru.dev.bottled.cola.hackathon.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "preferences")
public class Preference {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(mappedBy = "preferences")
    List<Profile> profiles;

    @ManyToMany(mappedBy = "preferences")
    List<TatarService> services;

    @ManyToMany(mappedBy = "preferences")
    List<Event> events;

    private String name;
}
