package org.company.order.domain;

import lombok.Getter;
import org.company.order.shared.SelfValidating;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
public class Order extends SelfValidating<Order> {

    @NotBlank
    private String orderUUID;

    @NotBlank
    private String ordererId;

    @NotBlank
    private String orderedIem;

    private String assignedCourierId;

    @NotNull
    private OrderStatus orderStatus;

    @NotBlank
    private String deliveryAddress;

    @NotNull
    private LocalDateTime createdAt;

    @NotNull
    private LocalDateTime updatedAt;

    @NotEmpty
    private String trackingRefNo;

    @NotNull
    private ContactInfo senderInfo;

    @NotNull
    private ContactInfo receiverInfo;

    @Size(max = 256)
    private String ordererNotes;

    @Size(max = 256)
    private String systemNotes;

    public Order(String orderUUID, String ordererId, String orderedIem, String assignedCourierId,
                 OrderStatus orderStatus, String deliveryAddress, LocalDateTime createdAt, LocalDateTime updatedAt,
                 String trackingRefNo, ContactInfo senderInfo, ContactInfo receiverInfo, String ordererNotes,
                 String systemNotes) {
        this.orderUUID = orderUUID;
        this.ordererId = ordererId;
        this.orderedIem = orderedIem;
        this.assignedCourierId = assignedCourierId;
        this.orderStatus = orderStatus;
        this.deliveryAddress = deliveryAddress.trim();
        this.createdAt = createdAt == null ? LocalDateTime.now() : createdAt;
        this.updatedAt = updatedAt;
        this.trackingRefNo = trackingRefNo;
        this.senderInfo = senderInfo;
        this.receiverInfo = receiverInfo;
        this.ordererNotes = ordererNotes != null ? ordererNotes.trim() : "";
        this.systemNotes = systemNotes != null ? systemNotes.trim() : "";

        this.validateSelf();
    }
}
