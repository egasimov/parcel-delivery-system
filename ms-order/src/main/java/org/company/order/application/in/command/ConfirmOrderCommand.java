package org.company.order.application.in.command;

import lombok.Getter;
import org.company.order.shared.SelfValidating;

import javax.validation.constraints.NotBlank;

@Getter
public class ConfirmOrderCommand extends SelfValidating<ConfirmOrderCommand> {

    @NotBlank
    private String orderUUID;

    public ConfirmOrderCommand(String orderUUID) {
        this.orderUUID = orderUUID;
    }
}
