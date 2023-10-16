package se331.lab.rest.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import se331.lab.rest.security.user.Role;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class OrganizerAuthDTO {
    Long id;
    String name;
    List<Role> roles = new ArrayList<>();
}
