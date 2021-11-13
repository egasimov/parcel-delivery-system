package org.company.user.controller;

import lombok.RequiredArgsConstructor;
import org.company.user.model.CreateCustomerRequest;
import org.company.user.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/username/{username}")
    public ResponseEntity getCustomer(@PathVariable String username) {

        return ResponseEntity.ok("customerDto");
    }

    @GetMapping()
    public ResponseEntity<List<Object>> getCustomers() {
        return ResponseEntity.ok(null);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity createCustomer(@RequestBody CreateCustomerRequest createCustomerData) {
        customerService.createCustomer(createCustomerData);
        return ResponseEntity.ok("SUCCESS");
    }

    @DeleteMapping("/username/{username}")
    public ResponseEntity deleteCustomer(@PathVariable String username) {
        return ResponseEntity.ok("SUCCESS");
    }

}
