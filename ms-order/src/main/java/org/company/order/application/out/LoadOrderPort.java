package org.company.order.application.out;

import org.company.order.domain.Order;
import org.company.order.domain.OrderStatus;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface LoadOrderPort {
    Optional<Order> loadByUUID(String orderUUID);

    Optional<Order> loadByTrackingRefNo(String trackingRefNo);

    List<Order> loadOrdersOfOrderer(String ordererId, LocalDate from, LocalDate to);

    List<Order> filterOrdersOfOrdererByStatus(String ordererId, OrderStatus status);

    List<Order> loadOrdersOfCourier(String courierId, LocalDate from, LocalDate to);
}
