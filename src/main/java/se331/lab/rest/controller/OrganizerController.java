package se331.lab.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;
import se331.lab.rest.entity.Organizer;
import se331.lab.rest.service.OrganizerService;

import java.util.List;

@Controller
@RequiredArgsConstructor

public class OrganizerController {
    final OrganizerService organizerService;

    @GetMapping("organizers")
    public ResponseEntity<?> getOrganizerList(@RequestParam(value = "_limit",required = false)
                                              Integer perPage, @RequestParam(value = "_page", required = false)Integer page){
        List<Organizer> output = null;
        Integer organizerSize = organizerService.getOrganizerSize();
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("x-total-count", String.valueOf(organizerSize));
        try {
            output = organizerService.getOrganizers(perPage, page);
            return  new ResponseEntity<>(output, responseHeaders, HttpStatus.OK);
        } catch (IndexOutOfBoundsException ex) {
            return  new ResponseEntity<>(output, responseHeaders, HttpStatus.OK);
        }
    }
}
