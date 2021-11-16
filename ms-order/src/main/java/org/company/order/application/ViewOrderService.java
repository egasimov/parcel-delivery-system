package org.company.order.application;

import org.company.order.application.in.query.ViewOrderQuery;

import java.time.LocalDate;
import java.util.List;

public class ViewOrderService implements ViewOrderQuery {
    @Override
    public Object queryByOrderUUID(String orderUUID) {
        return null;
    }

    @Override
    public List<Object> queryAllOrdersOfCourier(String courierID, LocalDate from, LocalDate to) {
        return null;
    }

    @Override
    public List<Object> queryAllOrdersOfCustomer(String customerID, LocalDate from, LocalDate to) {
        return null;
    }
}
