package se331.lab.rest.dao;

import jakarta.annotation.PostConstruct;
import org.aspectj.weaver.ast.Or;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import  org.springframework.stereotype.Repository;
import se331.lab.rest.entity.Organizer;

import java.util.List;
import java.util.ArrayList;

@Repository
@Profile("manual")
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
    public Page<Organizer> getOrganizer(Integer pageSize, Integer page){
        pageSize = pageSize == null ? organizerList.size() : pageSize;
        page = page == null ? 1 : page;
        int firstIndex = (page - 1 )* pageSize;
        return new PageImpl<Organizer>(organizerList.subList(firstIndex, firstIndex + pageSize),
                PageRequest.of(pageSize, page),organizerList.size());

    }

    @Override
    public Organizer getOrganizer(Long id){
        return organizerList.stream().filter(organizer ->
                organizer.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public Organizer save(Organizer organizer){
        organizer.setId(organizerList.get(organizerList.size()-1).getId()+1);
        organizerList.add(organizer);
        return organizer;
    }
}
