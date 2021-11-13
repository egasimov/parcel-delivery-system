package org.company.user.service.impl;

import org.company.user.model.CreateUserRequest;
import org.company.user.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public boolean checkUserExist(String username) {
        return false;
    }

    @Override
    public boolean createUser(CreateUserRequest createUserRequest) {
        return false;
    }
}
