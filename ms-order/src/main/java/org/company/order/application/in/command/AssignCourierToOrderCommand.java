package org.company.order.application.in.command;

import lombok.Getter;
import org.company.order.shared.SelfValidating;

import javax.validation.constraints.NotBlank;

@Getter
public class AssignCourierToOrderCommand extends SelfValidating<AssignCourierToOrderCommand> {

    @NotBlank
    private String orderUUID;

    @NotBlank
    private String assignedCourierId;

    public AssignCourierToOrderCommand(String orderUUID, String assignedCourierId) {
        this.orderUUID = orderUUID;
        this.assignedCourierId = assignedCourierId;
    }
}
