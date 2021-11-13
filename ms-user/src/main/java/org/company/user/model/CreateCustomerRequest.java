package org.company.user.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateCustomerRequest {

    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String email;
    private String username;
    private String password;
    private String address;
    private String phoneNumber;

}
