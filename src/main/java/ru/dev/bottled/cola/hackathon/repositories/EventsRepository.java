package ru.dev.bottled.cola.hackathon.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.dev.bottled.cola.hackathon.models.Event;
import ru.dev.bottled.cola.hackathon.models.Preference;

import java.util.Date;
import java.util.List;

@Repository
public interface EventsRepository extends JpaRepository<Event, Long> {
    @Query(value = "SELECT * FROM events e WHERE e.date > ?1 AND e.preferences = ?2 AND e.likes > ?3",
            nativeQuery = true)
    List<Event> getInterestingEvents(Date date, List<Preference> preferences, int likes);
}
