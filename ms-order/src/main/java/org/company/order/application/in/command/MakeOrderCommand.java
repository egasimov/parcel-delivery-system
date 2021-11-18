package org.company.order.application.in.command;

import lombok.Getter;
import org.company.order.domain.ContactInfo;
import org.company.order.shared.SelfValidating;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
public class MakeOrderCommand extends SelfValidating<MakeOrderCommand> {

    @NotBlank
    private String orderUUID;

    @NotBlank
    private String ordererId;

    @NotBlank
    private String orderedIem;

    @NotBlank
    private String deliveryAddress;

    @NotEmpty
    private String trackingRefNo;

    @NotNull
    private ContactInfo senderInfo;

    @NotNull
    private ContactInfo receiverInfo;

    private String ordererNotes;

    public MakeOrderCommand(String orderUUID, String ordererId, String orderedIem, String deliveryAddress, String trackingRefNo, ContactInfo senderInfo, ContactInfo receiverInfo, String ordererNotes) {
        this.orderUUID = orderUUID;
        this.ordererId = ordererId;
        this.orderedIem = orderedIem;
        this.deliveryAddress = deliveryAddress;
        this.trackingRefNo = trackingRefNo;
        this.senderInfo = senderInfo;
        this.receiverInfo = receiverInfo;
        this.ordererNotes = ordererNotes;
    }
}
