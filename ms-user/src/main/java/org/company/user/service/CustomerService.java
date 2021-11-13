package org.company.user.service;

import org.company.user.model.dto.CustomerDto;
import org.company.user.model.request.CreateCustomerRequest;

import java.util.List;

public interface CustomerService {
    CustomerDto createCustomer(CreateCustomerRequest createCustomerRequest);
    CustomerDto findCustomer(String username);
    List<CustomerDto> findAllCustomers();
    void removeCustomer(String username);
    CustomerDto info();
}
