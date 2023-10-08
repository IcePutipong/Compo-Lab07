package se331.lab.rest.service;

import org.springframework.data.domain.Page;
import se331.lab.rest.entity.Participant;

import java.util.List;

public interface ParticipantService {
    List<Participant> getAllParticipant();
    Page<Participant> getParticipant(Integer page, Integer PageSize);
}
