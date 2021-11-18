package org.company.order.application.views;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;
import org.company.order.domain.Order;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Jacksonized
public class ExtendedOrderView {

    private String orderUUID;
    private String ordererId;
    private String orderedIem;
    private String orderStatus;
    private String deliveryAddress;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String trackingRefNo;
    private ContactDetailsView senderInfo;
    private ContactDetailsView receiverInfo;
    private String ordererNotes;

    public static ExtendedOrderView construct(Order order) {
        return ExtendedOrderView.builder()
                .orderUUID(order.getOrderUUID())
                .ordererId(order.getOrdererId())
                .orderedIem(order.getOrderedIem())
                .orderStatus(order.getOrderStatus().name())
                .deliveryAddress(order.getDeliveryAddress())
                .createdAt(order.getCreatedAt())
                .updatedAt(order.getUpdatedAt())
                .trackingRefNo(order.getTrackingRefNo())
                .senderInfo(ContactDetailsView.construct(order.getSenderInfo()))
                .receiverInfo(ContactDetailsView.construct(order.getReceiverInfo()))
                .ordererNotes(order.getOrdererNotes())
                .build();
    }
}
