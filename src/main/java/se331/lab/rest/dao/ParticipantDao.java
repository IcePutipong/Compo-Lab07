package se331.lab.rest.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.lab.rest.entity.Participant;

public interface ParticipantDao {
    Page<Participant> getParticipant(Pageable pageRequest);
}
