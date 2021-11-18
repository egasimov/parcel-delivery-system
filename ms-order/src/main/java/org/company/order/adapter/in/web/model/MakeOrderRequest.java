package org.company.order.adapter.in.web.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class MakeOrderRequest {

    @NotNull
    private String ordererId;

    @NotNull
    private String orderedIem;

    @NotNull
    private String deliveryAddress;

    @NotNull
    private ContactDetailsModel senderInfo;

    @NotNull
    private ContactDetailsModel receiverInfo;

    private String ordererNotes;
}
