package org.company.order.application.in;

import org.company.order.application.in.command.AssignCourierToOrderCommand;
import org.company.order.application.in.command.ChangeOrderStatusCommad;
import org.company.order.application.in.command.ConfirmOrderCommand;

public interface UpdateOrderUseCase {
    void assignCourier(AssignCourierToOrderCommand command);

    void changeOrderStatus(ChangeOrderStatusCommad command);
}
