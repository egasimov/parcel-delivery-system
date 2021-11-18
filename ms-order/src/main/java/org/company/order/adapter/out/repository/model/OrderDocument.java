package org.company.order.adapter.out.repository.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;
import org.company.order.domain.Order;
import org.company.order.domain.OrderStatus;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Document("orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Jacksonized
public class OrderDocument {
    @Id
    private String orderUUID;

    private String ordererId;
    private String orderedIem;
    private String assignedCourierId;
    private OrderStatus orderStatus;
    private String deliveryAddress;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime createdAt;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime updatedAt;

    @Indexed(unique = true)
    private String trackingRefNo;

    private ContactInfoDocument senderInfo;
    private ContactInfoDocument receiverInfo;
    private String ordererNotes;
    private String systemNotes;


    public static Order toEntity(OrderDocument doc) {
        var receiverInfo = ContactInfoDocument.toEntity(doc.getReceiverInfo());
        var senderInfo = ContactInfoDocument.toEntity(doc.getSenderInfo());

        var order = new Order(doc.getOrderUUID(), doc.getOrdererId(), doc.getOrderedIem(),
                doc.getAssignedCourierId(), doc.getOrderStatus(), doc.getDeliveryAddress(),
                doc.getCreatedAt(), doc.getUpdatedAt(), doc.getTrackingRefNo(),
                receiverInfo, senderInfo,
                doc.getOrdererNotes(), doc.getSystemNotes());

        return order;
    }

    public static OrderDocument toDocument(Order entity) {
        var receiverInfo = ContactInfoDocument.toDocument(entity.getReceiverInfo());
        var senderInfo = ContactInfoDocument.toDocument(entity.getSenderInfo());

        var document = OrderDocument.builder()
                .orderUUID(entity.getOrderUUID())
                .ordererId(entity.getOrdererId())
                .orderedIem(entity.getOrderedIem())
                .assignedCourierId(entity.getAssignedCourierId())
                .orderStatus(entity.getOrderStatus())
                .deliveryAddress(entity.getDeliveryAddress())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .trackingRefNo(entity.getTrackingRefNo())
                .senderInfo(senderInfo)
                .receiverInfo(receiverInfo)
                .ordererNotes(entity.getOrdererNotes())
                .systemNotes(entity.getSystemNotes())
                .build();

        return document;
    }
}
