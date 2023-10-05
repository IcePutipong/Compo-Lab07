package se331.lab.rest.dao;

import se331.lab.rest.entity.Organizer;

import org.springframework.data.domain.Page;
public interface OrganizerDao {
    Integer getOrganizerSize();

    Page<Organizer> getOrganizer(Integer pageSize, Integer page);
    Organizer getOrganizer(Long id);

    Organizer save(Organizer organizer);
}
