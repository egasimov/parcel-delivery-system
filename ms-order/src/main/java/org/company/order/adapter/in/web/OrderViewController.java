package org.company.order.adapter.in.web;

import lombok.RequiredArgsConstructor;
import org.company.order.application.in.query.ViewOrderQuery;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
@Validated
public class OrderViewController {

    private final ViewOrderQuery viewOrderQuery;

    @GetMapping("/{orderUUID}")
    public ResponseEntity<Object> getOrderByOrderUUID(@PathVariable @Valid @NotBlank String orderUUID) {

        Object result = viewOrderQuery.queryByOrderUUID(orderUUID);

        return ResponseEntity.ok(result);
    }

    @GetMapping("/customer-history")
    public ResponseEntity<Object> getAllCustomerOrders(@DateTimeFormat(pattern = "dd.MM.yyyy")
                                                       @RequestParam LocalDate from,
                                                       @DateTimeFormat(pattern = "dd.MM.yyyy")
                                                       @RequestParam LocalDate to,
                                                       @RequestParam String customerID) {

        long daysBetween = DAYS.between(from, to);

        if (daysBetween > 90){
            throw new RuntimeException("Interval exceeds 90 days");
        }
        Object result = viewOrderQuery.queryAllOrdersOfCustomer(customerID, from, to);

        return ResponseEntity.ok(result);
    }

    @GetMapping("/courier-history")
    public ResponseEntity<Object> getAllOrdersAssignedToCourier(
            @DateTimeFormat(pattern = "dd.MM.yyyy")
            @RequestParam LocalDate from,
            @DateTimeFormat(pattern = "dd.MM.yyyy")
            @RequestParam LocalDate to,
            @RequestParam String courierID) {

        long daysBetween = DAYS.between(from, to);

        if (daysBetween > 90){
            throw new RuntimeException("Interval exceeds 90 days");
        }

        Object result = viewOrderQuery.queryAllOrdersOfCourier(courierID, from, to);

        return ResponseEntity.ok(result);
    }
}
