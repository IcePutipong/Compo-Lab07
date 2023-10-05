package se331.lab.rest.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import se331.lab.rest.entity.Event;
import se331.lab.rest.entity.Organizer;
import se331.lab.rest.repository.EventRepository;
import se331.lab.rest.repository.OrganizerRepository;

@Component
@RequiredArgsConstructor
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    final EventRepository eventRepository;
    final OrganizerRepository organizerRepository;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        eventRepository.save(Event.builder()
                .category("Academic")
                .title("Midterm Exam")
                .description("A time for taking the exam")
                .location("CAMT Building")
                .date("3rd Sept")
                .time("3.00-4.00 pm.")
                .petAllowed(false)
                .organizer("CAMT").build());
        eventRepository.save(Event.builder()
                .category("Academic")
                .title("Commencement Day")
                .description("A time for celebration")
                .location("CMU Convention hall")
                .date("21th Jan")
                .time("8.00am-4.00 pm.")
                .petAllowed(false)
                .organizer("CMU").build());
        eventRepository.save(Event.builder()
                .category("Cultural")
                .title("Loy Krathong")
                .description("A time for Krathong")
                .location("Ping River")
                .date("21th Nov")
                .time("8.00-10.00 pm.")
                .petAllowed(false)
                .organizer("Chiang Mai").build());
        eventRepository.save(Event.builder()
                .category("Cultural")
                .title("Songkran")
                .description("Let's Play Water")
                .location("Chiang Mai Moat")
                .date("13th April")
                .time("10.00am - 6.00 pm.")
                .petAllowed(true)
                .organizer("Chiang Mai Municipality").build());

        organizerRepository.save(Organizer.builder()
                .id(496L)
                .name("Jonny Wu")
                .address("123 Main St, New York")
                .build());
        organizerRepository.save(Organizer.builder()
                .id(655L)
                .name("Cocolia Marhier")
                .address("456 Elm St, Los Angeles")
                .build());
        organizerRepository.save(Organizer.builder()
                .id(452L)
                .name("Chen Long Lee")
                .address("789 Oak Ave, Chicago")
                .build());
        organizerRepository.save(Organizer.builder()
                .id(426L)
                .name("Kat Laydee")
                .address("489 Main St, New York")
                .build());
        organizerRepository.save(Organizer.builder()
                .id(615L)
                .name("Fern Pollin")
                .address("896 Elm St, Los Angeles")
                .build());
        organizerRepository.save(Organizer.builder()
                .id(444L)
                .name("Carey Wales")
                .address("786 Oak Ave, Chicago")
                .build());
    }

}
