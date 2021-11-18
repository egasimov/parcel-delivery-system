package org.company.order.application;

import lombok.RequiredArgsConstructor;
import org.company.order.application.in.MakeOrderUseCase;
import org.company.order.application.in.UpdateOrderUseCase;
import org.company.order.application.in.command.AssignCourierToOrderCommand;
import org.company.order.application.in.command.ChangeOrderStatusCommad;
import org.company.order.application.in.command.MakeOrderCommand;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderCommandService implements MakeOrderUseCase, UpdateOrderUseCase {

    @Override
    public void order(MakeOrderCommand command) {

    }

    @Override
    public void assignCourier(AssignCourierToOrderCommand command) {

    }

    @Override
    public void changeOrderStatus(ChangeOrderStatusCommad command) {

    }
}
