package se331.lab.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import se331.lab.rest.service.ParticipantService;
import se331.lab.rest.util.LabMapper;

@RestController
@RequiredArgsConstructor
public class ParticipantController {
    final ParticipantService participantService;

    @GetMapping("/participants")
    ResponseEntity<?> getParticipant(){
        return ResponseEntity.ok(LabMapper.INSTANCE.getParticipantEventDTO(participantService.getAllParticipant()));
    }

}
