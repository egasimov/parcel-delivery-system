package org.company.order.application.views;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;
import org.company.order.domain.Order;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Jacksonized
public class SimpleOrderView {
    private String orderUUID;
    private String ordererId;
    private String orderedIem;
    private String orderStatus;
    private String trackingRefNo;
    private String deliveryAddress;

    public static SimpleOrderView construct(Order order) {
        return SimpleOrderView.builder()
                .orderUUID(order.getOrderUUID())
                .ordererId(order.getOrdererId())
                .orderedIem(order.getOrderedIem())
                .orderStatus(order.getOrderStatus().name())
                .deliveryAddress(order.getDeliveryAddress())
                .trackingRefNo(order.getTrackingRefNo())
                .build();
    }
}
