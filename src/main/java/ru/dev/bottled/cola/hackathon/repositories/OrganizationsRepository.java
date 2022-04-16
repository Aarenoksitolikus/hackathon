package ru.dev.bottled.cola.hackathon.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dev.bottled.cola.hackathon.models.Organization;

@Repository
public interface OrganizationsRepository  extends JpaRepository<Organization, Long> {
}
