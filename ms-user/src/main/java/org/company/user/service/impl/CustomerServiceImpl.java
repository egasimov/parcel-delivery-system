package org.company.user.service.impl;

import org.company.user.domain.entities.Customer;
import org.company.user.error.exception.DuplicateRecordException;
import org.company.user.error.exception.RecordNotFoundException;
import org.company.user.mapper.CustomerMapper;
import org.company.user.model.dto.CustomerDto;
import org.company.user.model.request.CreateCustomerRequest;
import org.company.user.model.request.CreateUserRequest;
import org.company.user.repository.CustomerRepository;
import org.company.user.security.RoleConstants;
import org.company.user.service.CustomerService;
import org.company.user.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final UserService userService;
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository,
                               UserService userService) {
        this.userService = userService;
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerDto createCustomer(CreateCustomerRequest requestData) {

        requestData.setUsername(requestData.getUsername().toLowerCase());

        boolean userExist = userService.checkUserExist(requestData.getUsername().toLowerCase());

        if (userExist) {
            throw DuplicateRecordException.of("customer/user already exist");
        }

        var createUserRequest = CreateUserRequest.builder()
                .firstName(requestData.getFirstName())
                .lastName(requestData.getLastName())
                .username(requestData.getUsername())
                .password(requestData.getPassword())
                .enabled(Boolean.TRUE)
                .userClientRoles(List.of(RoleConstants.ROLE_CLIENT_USER_CUSTOMER))
                .userRealmRoles(List.of(RoleConstants.ROLE_REALM_USER_CUSTOMER))
                .build();

        userService.createUser(createUserRequest);

        var newEntity = CustomerMapper.toCustomerEntity(requestData);
        customerRepository.save(newEntity);

        return CustomerMapper.toCustomerDto(newEntity);
    }

    @Override
    public CustomerDto findCustomer(String username) {
        Customer customer = customerRepository.findByUsername(username).orElseThrow(() -> RecordNotFoundException.of("Customer does not exist"));
        return CustomerMapper.toCustomerDto(customer);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CustomerDto> findAllCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(CustomerMapper::toCustomerDto)
                .collect(Collectors.toList());
    }

    @Override
    public void removeCustomer(String username) {
        Customer customer = customerRepository.findByUsername(username)
                .orElseThrow(() -> RecordNotFoundException.of("customer does not exist"));
        userService.removeUser(username);
        customerRepository.deleteById(customer.getId());
    }

    @Override
    public CustomerDto info() {
        String username = userService.currentLoggedUser();
        var customer = customerRepository
                .findByUsername(username)
                .orElseThrow(() -> RecordNotFoundException.of("customer does not exist"));
        return CustomerMapper.toCustomerDto(customer);
    }
}
