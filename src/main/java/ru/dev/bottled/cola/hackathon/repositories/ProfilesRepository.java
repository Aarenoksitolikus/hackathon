package ru.dev.bottled.cola.hackathon.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dev.bottled.cola.hackathon.models.Profile;

@Repository
public interface ProfilesRepository extends JpaRepository<Profile, Long> {
}
