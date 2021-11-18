package org.company.order.application.in.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.company.order.domain.OrderStatus;

@AllArgsConstructor
@Getter
public class ChangeOrderStatusCommad {
    private String orderUUID;
    private OrderStatus orderStatus;
}
