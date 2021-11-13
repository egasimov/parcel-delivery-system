package org.company.user.model.dto;

import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

import java.util.List;
import java.util.Map;

@Builder
@Jacksonized
public class UserDto {

    private String userName;
    private String firstName;
    private String lastName;
    private String id;
    private String email;
    private Map<String, List<String>> additionalAttributes;

}
