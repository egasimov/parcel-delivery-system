package org.company.user.service.impl;

import org.company.user.error.exception.UserAlreadyExistException;
import org.company.user.model.CreateCustomerRequest;
import org.company.user.model.CreateUserRequest;
import org.company.user.service.CustomerService;
import org.company.user.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final UserService userService;

    public CustomerServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void createCustomer(CreateCustomerRequest requestData) {

        boolean userExist = userService.checkUserExist(requestData.getUsername().toLowerCase());
        if (userExist) {
            throw UserAlreadyExistException.of("user already exist");
        }

        var createUserRequest = CreateUserRequest.builder()
                .firstName(requestData.getFirstName())
                .lastName(requestData.getLastName())
                .username(requestData.getUsername().toLowerCase())
                .password(requestData.getPassword())
                .enabled(Boolean.TRUE)
                .build();

        userService.createUser(createUserRequest);

    }
}
