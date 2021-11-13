package org.company.user.model.request;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CreateUserRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
    private Boolean enabled;
    private List<String> userRealmRoles;
    private List<String> userClientRoles;

}
