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
@Table(name = "services")
public class TatarService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String link;

    @ManyToMany
    @JoinTable(
            name = "service_prefs",
            joinColumns = @JoinColumn(name = "service_id"),
            inverseJoinColumns = @JoinColumn(name = "preference_id"))
    List<Preference> preferences;

    @ManyToMany(mappedBy = "likedServices")
    List<Profile> likes;

    @OneToMany(mappedBy = "source", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    List<Comment> comments;
}
