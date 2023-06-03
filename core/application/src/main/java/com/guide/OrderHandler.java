package com.guide;

import com.guide.entity.Order;
import jakarta.inject.Singleton;
import lombok.AllArgsConstructor;

@Singleton
@AllArgsConstructor
public class OrderHandler {

    private final OrderRepository orderRepository;
    public String handle(OrderCmd.OrderCreateCmd orderCreateCmd) {
        Order order = Order.createEmpty(orderCreateCmd.locationId(), orderCreateCmd.customerId());
        boolean isSuccessful = orderRepository.save(order);
        if (isSuccessful) {
            return order.orderId();
        } else {
            throw new IllegalStateException("Order could not be created");
        }
    }
}
