package org.company.user.service;

import org.company.user.model.CreateUserRequest;

public interface UserService {
    boolean checkUserExist(String username);
    boolean createUser(CreateUserRequest createUserRequest);
}
