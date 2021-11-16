package org.company.order.application.in.query;

import java.time.LocalDate;
import java.util.List;

public interface ViewOrderQuery {
    Object queryByOrderUUID(String orderUUID);

    List<Object> queryAllOrdersOfCourier(String courierID, LocalDate from, LocalDate to);

    List<Object> queryAllOrdersOfCustomer(String customerID, LocalDate from, LocalDate to);
}
