package org.company.user.model;

import lombok.Builder;

@Builder
public class CreateUserRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
    private Boolean enabled;
}
