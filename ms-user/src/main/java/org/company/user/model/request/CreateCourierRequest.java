package org.company.user.model.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateCourierRequest {

    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String email;
    private String username;
    private String password;
    private String address;
    private String phoneNumber;
    private String location;

}
