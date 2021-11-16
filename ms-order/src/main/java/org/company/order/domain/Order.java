package org.company.order.domain;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
public class Order {
    
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

    private String ordererNotes;
    private String systemNotes;

}
