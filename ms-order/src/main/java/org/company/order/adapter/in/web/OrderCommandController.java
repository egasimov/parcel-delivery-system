package org.company.order.adapter.in.web;

import lombok.RequiredArgsConstructor;
import org.company.order.adapter.in.web.model.MakeOrderRequest;
import org.company.order.adapter.in.web.model.MakeOrderResponse;
import org.company.order.application.in.MakeOrderUseCase;
import org.company.order.application.in.UpdateOrderUseCase;
import org.company.order.application.in.command.AssignCourierToOrderCommand;
import org.company.order.application.in.command.ChangeOrderStatusCommad;
import org.company.order.application.in.command.MakeOrderCommand;
import org.company.order.domain.ContactInfo;
import org.company.order.domain.OrderStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
@Validated
public class OrderCommandController {

    private final MakeOrderUseCase makeOrderUseCase;
    private final UpdateOrderUseCase updateOrderUseCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<MakeOrderResponse> makeOrder(@RequestBody @Valid MakeOrderRequest request) {

        var orderUUID = UUID.randomUUID().toString();
        var trackingRefNo = UUID.randomUUID().toString();
        var senderContactInfo = new ContactInfo(request.getSenderInfo().getName(), request.getSenderInfo().getPhone());
        var receiverContactInfo = new ContactInfo(request.getReceiverInfo().getName(), request.getReceiverInfo().getPhone());

        final MakeOrderCommand command = new MakeOrderCommand(
                orderUUID,
                request.getOrdererId(),
                request.getOrderedIem(),
                request.getDeliveryAddress(),
                trackingRefNo,
                senderContactInfo, receiverContactInfo,
                request.getOrdererNotes());

        makeOrderUseCase.order(command);

        MakeOrderResponse response = new MakeOrderResponse(command.getOrderUUID(), command.getTrackingRefNo(),
                OrderStatus.WAITING_TO_CONFIRM.name(), "Order is created, tracking ref-no will be active when you confirm");

        return ResponseEntity.of(Optional.of(response));
    }

    @PutMapping("/{orderUUID}/confirm")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity confirmOrder(@PathVariable @Valid @NotBlank String orderUUID) {

        final ChangeOrderStatusCommad command = new ChangeOrderStatusCommad(orderUUID, OrderStatus.SEARCHING_OF_COURIER);

        updateOrderUseCase.changeOrderStatus(command);

        return ResponseEntity.ok("Order Confirmation Request is received, and putted into processing");
    }

    @PutMapping("/{orderUUID}/complete")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity completeOrder(@PathVariable @Valid @NotBlank String orderUUID) {

        final ChangeOrderStatusCommad command = new ChangeOrderStatusCommad(orderUUID, OrderStatus.DELIVERY_COMPLETED);

        updateOrderUseCase.changeOrderStatus(command);

        return ResponseEntity.ok("Order Delivery Complete Request is received, and putted into processing");
    }

    @PutMapping("/{orderUUID}/cancel")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity cancelOrder(@PathVariable @Valid @NotBlank String orderUUID) {

        final ChangeOrderStatusCommad command = new ChangeOrderStatusCommad(orderUUID, OrderStatus.CANCELLED);

        updateOrderUseCase.changeOrderStatus(command);

        return ResponseEntity.ok("Order Delivery Cancel Request is received, and putted into processing");
    }

    @PutMapping("/{orderUUID}/assign-courier")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity assignCourier(@PathVariable @Valid @NotBlank String orderUUID, @RequestParam("courier_id") @Valid @NotBlank String courierId) {

        final AssignCourierToOrderCommand command = new AssignCourierToOrderCommand(orderUUID, courierId);

        updateOrderUseCase.assignCourier(command);

        return ResponseEntity.ok("Assign Courier To Order  Request is received, and putted into processing");
    }

}
