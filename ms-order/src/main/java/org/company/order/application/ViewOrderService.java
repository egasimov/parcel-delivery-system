package org.company.order.application;

import lombok.RequiredArgsConstructor;
import org.company.order.application.in.query.ViewOrderQuery;
import org.company.order.application.out.LoadOrderPort;
import org.company.order.application.views.ExtendedOrderView;
import org.company.order.application.views.SimpleOrderView;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ViewOrderService implements ViewOrderQuery {

    private final LoadOrderPort loadOrderPort;

    @Override
    public SimpleOrderView queryBySimpleOrderViewUUID(String orderUUID) {
        var order = loadOrderPort.loadByUUID(orderUUID)
                .orElseThrow(() -> new RuntimeException("Order Not Found"));

        var orderView = SimpleOrderView.construct(order);

        return orderView;
    }

    @Override
    public ExtendedOrderView queryByExtendedOrderViewUUID(String orderUUID) {
        var order = loadOrderPort.loadByUUID(orderUUID)
                .orElseThrow(() -> new RuntimeException("Order Not Found"));

        var extendedView = ExtendedOrderView.construct(order);

        return extendedView;
    }

    @Override
    public List<SimpleOrderView> queryAllSimpleOrderViewOfOrderer(String ordererId, LocalDate from, LocalDate to) {
        return loadOrderPort.loadOrdersOfOrderer(ordererId, from, to)
                .stream()
                .map(SimpleOrderView::construct)
                .collect(Collectors.toList());
    }

    @Override
    public List<SimpleOrderView> queryAllSimpleOrderViewOfCourier(String courierID, LocalDate from, LocalDate to) {
        return List.of();
    }
}
