package org.company.order.application.in.query;

import org.company.order.application.views.ExtendedOrderView;
import org.company.order.application.views.SimpleOrderView;

import java.time.LocalDate;
import java.util.List;

public interface ViewOrderQuery {

    SimpleOrderView queryBySimpleOrderViewUUID(String orderUUID);

    ExtendedOrderView queryByExtendedOrderViewUUID(String orderUUID);

    List<SimpleOrderView> queryAllSimpleOrderViewOfOrderer(String courierID, LocalDate from, LocalDate to);

    List<SimpleOrderView> queryAllSimpleOrderViewOfCourier(String customerID, LocalDate from, LocalDate to);
}
