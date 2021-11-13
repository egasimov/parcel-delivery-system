package org.company.user.mapper;

import org.company.user.model.dto.UserDto;
import org.keycloak.models.UserModel;
import org.keycloak.representations.idm.UserRepresentation;

public class UserMapper {

    public static UserDto mapToUserDto(UserModel um) {
        return UserDto.builder()
                .id(um.getId())
                .firstName(um.getFirstName())
                .lastName(um.getLastName())
                .userName(um.getUsername())
                .email(um.getEmail())
                .additionalAttributes(um.getAttributes())
                .build();
    }

    public static UserDto mapToUserDto(UserRepresentation um) {
        return UserDto.builder()
                .id(um.getId())
                .firstName(um.getFirstName())
                .lastName(um.getLastName())
                .userName(um.getUsername())
                .email(um.getEmail())
                .additionalAttributes(um.getAttributes())
                .build();
    }
}
