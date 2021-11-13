package org.company.user.service;

import org.company.user.model.dto.UserDto;
import org.company.user.model.request.CreateUserRequest;

import java.util.List;

public interface UserService {
    boolean checkUserExist(String username);

    void createUser(CreateUserRequest createUserRequest);

    List<UserDto> getAllUsers();

    void removeUser(String username);

    String currentLoggedUser();
}
