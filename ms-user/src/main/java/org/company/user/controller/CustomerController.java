package org.company.user.controller;

import lombok.RequiredArgsConstructor;
import org.company.user.model.dto.CustomerDto;
import org.company.user.model.request.CreateCustomerRequest;
import org.company.user.security.RoleConstants;
import org.company.user.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
@Validated
public class CustomerController {

    private final CustomerService customerService;

    @RolesAllowed(RoleConstants.ClientApp.ROLE_GET_ANY_CUSTOMER_INFO)
    @GetMapping("/username/{username}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity getCustomer(@PathVariable String username) {
        return ResponseEntity.ok(customerService.findCustomer(username));
    }

    @RolesAllowed(RoleConstants.ClientApp.ROLE_GET_SELF_CUSTOMER_INFO)
    @GetMapping("/info")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity info() {
        return ResponseEntity.ok(customerService.info());
    }

    @RolesAllowed(RoleConstants.ClientApp.ROLE_GET_ALL_CUSTOMER_INFO)
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<CustomerDto>> getAllCustomers() {
        return ResponseEntity.ok(customerService.findAllCustomers());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity createCustomer(@Valid @RequestBody CreateCustomerRequest createCustomerData) {
        return ResponseEntity.ok(customerService.createCustomer(createCustomerData));
    }

    @RolesAllowed(RoleConstants.ClientApp.ROLE_REMOVE_ANY_CUSTOMER)
    @DeleteMapping("/username/{username}")
    public ResponseEntity deleteCustomer(@PathVariable String username) {
        customerService.removeCustomer(username);
        return ResponseEntity.ok("SUCCESS");
    }

}
