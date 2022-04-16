package ru.dev.bottled.cola.hackathon.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "discussions")
public class Discussion {

    @Id
    @Column(name = "service_id")
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "service_id")
    @Setter(AccessLevel.NONE)
    private TatarService source;

    @OneToMany(mappedBy = "source", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    List<Comment> comments;
}
