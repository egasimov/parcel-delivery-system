package org.company.order.application.in;

import org.company.order.application.in.command.MakeOrderCommand;

public interface MakeOrderUseCase {
    void order(MakeOrderCommand command);
}
