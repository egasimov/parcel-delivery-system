package org.company.user.controller;

import lombok.RequiredArgsConstructor;
import org.company.user.model.dto.CourierDto;
import org.company.user.model.request.CreateCourierRequest;
import org.company.user.security.RoleConstants;
import org.company.user.service.CourierService;
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

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("/api/couriers")
@RequiredArgsConstructor
public class CourierController {

    private final CourierService courierService;

    @RolesAllowed(RoleConstants.ClientApp.ROLE_GET_ANY_COURIER_INFO)
    @GetMapping("/username/{username}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity getCourier(@PathVariable String username) {
        return ResponseEntity.ok(courierService.findCourier(username));
    }

    @RolesAllowed(RoleConstants.ClientApp.ROLE_GET_SELF_COURIER_INFO)
    @GetMapping("/info")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity info() {
        return ResponseEntity.ok(courierService.info());
    }

    @RolesAllowed(RoleConstants.ClientApp.ROLE_GET_ALL_COURIER_INFO)
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<CourierDto>> getAllCouriers() {
        return ResponseEntity.ok(courierService.findAllCouriers());
    }

    @RolesAllowed(RoleConstants.ClientApp.ROLE_CREATE_COURIER)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity createCourier(@RequestBody CreateCourierRequest createCourierData) {
        return ResponseEntity.ok(courierService.createCourier(createCourierData));
    }

    @RolesAllowed(RoleConstants.ClientApp.ROLE_REMOVE_ANY_COURIER)
    @DeleteMapping("/username/{username}")
    public ResponseEntity deleteCustomer(@PathVariable String username) {
        courierService.removeCourier(username);
        return ResponseEntity.ok("SUCCESS");
    }
}
