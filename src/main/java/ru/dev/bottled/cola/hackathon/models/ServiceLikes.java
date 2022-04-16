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

public class ServiceLikes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;




}
