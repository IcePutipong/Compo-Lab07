package se331.lab.rest.dao;

import jakarta.annotation.PostConstruct;
import  org.springframework.stereotype.Repository;
import se331.lab.rest.entity.Organizer;

import java.util.List;
import java.util.ArrayList;

@Repository
public class OrganizerDaoImpl implements OrganizerDao {
    List<Organizer> organizerList;

    @PostConstruct
    public void init(){
        organizerList = new ArrayList<>();
        organizerList.add(Organizer.builder()
                .id(496L)
                .name("Jonny Wu")
                .address("123 Main St, New York")
                .build());

        organizerList.add(Organizer.builder()
                .id(655L)
                .name("Cocolia Marhier")
                .address("456 Elm St, Los Angeles")
                .build());

        organizerList.add(Organizer.builder()
                .id(452L)
                .name("Chen Long Lee")
                .address("789 Oak Ave, Chicago")
                .build());

        organizerList.add(Organizer.builder()
                .id(426L)
                .name("Kat Laydee")
                .address("489 Main St, New York")
                .build());

        organizerList.add(Organizer.builder()
                .id(615L)
                .name("Fern Pollin")
                .address("896 Elm St, Los Angeles")
                .build());

        organizerList.add(Organizer.builder()
                .id(444L)
                .name("Carey Wales")
                .address("786 Oak Ave, Chicago")
                .build());
    }

    @Override
    public Integer getOrganizerSize() {
        return organizerList.size(); }

    @Override
    public List<Organizer> getOrganizer(Integer pageSize, Integer page){
        pageSize = pageSize == null ? organizerList.size() : pageSize;
        page = page == null ? 1 : page;
        int firstIndex = (page - 1 )* pageSize;
        return organizerList.subList(firstIndex,firstIndex+pageSize);

    }

    @Override
    public Organizer getOrganizer(Long id){
        return organizerList.stream().filter(organizer ->
                organizer.getId().equals(id)).findFirst().orElse(null);
    }
}
