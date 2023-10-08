package se331.lab.rest.config;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import se331.lab.rest.entity.Event;
import se331.lab.rest.entity.Organizer;
import se331.lab.rest.entity.Participant;
import se331.lab.rest.repository.EventRepository;
import se331.lab.rest.repository.OrganizerRepository;
import se331.lab.rest.repository.ParticipantRepository;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    final EventRepository eventRepository;
    final OrganizerRepository organizerRepository;
    final ParticipantRepository participantRepository;

    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {

        Organizer org1, org2, org3;
        org1 = organizerRepository.save(Organizer.builder()
                .name("CAMT").build());
        org2 = organizerRepository.save(Organizer.builder()
                .name("CMU").build());
        org3 = organizerRepository.save(Organizer.builder()
                .name("ChaingMai").build());

        Participant par1, par2, par3, par4, par5;
        par1 = participantRepository.save(Participant.builder()
                .name("Supinee").telNo("02-4569").build());
        par2 = participantRepository.save(Participant.builder()
                .name("Helen Na BanYang").telNo("06-4579").build());
        par3 = participantRepository.save(Participant.builder()
                .name("NuRat").telNo("02-6975").build());
        par4 = participantRepository.save(Participant.builder()
                .name("P'Boy").telNo("08-5894").build());
        par5 = participantRepository.save(Participant.builder()
                .name("Theerawan Na Sakdina").telNo("09-78244").build());

        Event tempEvent;
        tempEvent = eventRepository.save(Event.builder()
                .category("Academic")
                .title("Midterm Exam")
                .description("A time for taking the exam")
                .location("CAMT Building")
                .date("3rd Sept")
                .time("3.00-4.00 pm.")
                .petAllowed(false)
                .build());
        tempEvent.setOrganizer(org1);
        org1.getOwnEvent().add(tempEvent);



        tempEvent = eventRepository.save(Event.builder()
                .category("Academic")
                .title("Commencement Day")
                .description("A time for celebration")
                .location("CMU Convention hall")
                .date("21th Jan")
                .time("8.00am-4.00 pm.")
                .petAllowed(false)
                .build());
        tempEvent.setOrganizer(org1);
        org1.getOwnEvent().add(tempEvent);



        tempEvent = eventRepository.save(Event.builder()
                .category("Cultural")
                .title("Loy Krathong")
                .description("A time for Krathong")
                .location("Ping River")
                .date("21th Nov")
                .time("8.00-10.00 pm.")
                .petAllowed(false)
                .build());
        tempEvent.setOrganizer(org2);
        org2.getOwnEvent().add(tempEvent);


        tempEvent = eventRepository.save(Event.builder()
                .category("Cultural")
                .title("Songkran")
                .description("Let's Play Water")
                .location("Chiang Mai Moat")
                .date("13th April")
                .time("10.00am - 6.00 pm.")
                .petAllowed(true)
                .build());
        tempEvent.setOrganizer(org3);
        org3.getOwnEvent().add(tempEvent);


//        organizerRepository.save(Organizer.builder()
//                .id(496L)
//                .name("Jonny Wu")
//                .address("123 Main St, New York")
//                .build());
//        organizerRepository.save(Organizer.builder()
//                .id(655L)
//                .name("Cocolia Marhier")
//                .address("456 Elm St, Los Angeles")
//                .build());
//        organizerRepository.save(Organizer.builder()
//                .id(452L)
//                .name("Chen Long Lee")
//                .address("789 Oak Ave, Chicago")
//                .build());
//        organizerRepository.save(Organizer.builder()
//                .id(426L)
//                .name("Kat Laydee")
//                .address("489 Main St, New York")
//                .build());
//        organizerRepository.save(Organizer.builder()
//                .id(615L)
//                .name("Fern Pollin")
//                .address("896 Elm St, Los Angeles")
//                .build());
//        organizerRepository.save(Organizer.builder()
//                .id(444L)
//                .name("Carey Wales")
//                .address("786 Oak Ave, Chicago")
//                .build());
    }

}
