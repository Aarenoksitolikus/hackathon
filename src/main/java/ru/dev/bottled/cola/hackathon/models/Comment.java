package ru.dev.bottled.cola.hackathon.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "discussion_id")
    private Discussion source;

    @ManyToOne
    @JoinColumn(name = "author")
    private User author;

    private String content;
    private Timestamp publicationTime;
}
