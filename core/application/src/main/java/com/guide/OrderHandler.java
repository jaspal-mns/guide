package com.guide;

import com.guide.entity.Order;
import jakarta.inject.Singleton;
import lombok.AllArgsConstructor;

@Singleton
@AllArgsConstructor
public class OrderHandler {

    private final OrderRepository orderRepository;
    public String createOrder(OrderCmd.OrderCreateCmd orderCreateCmd) {
        Order order = Order.createEmpty(orderCreateCmd.locationId(), orderCreateCmd.customerId());
        boolean isSuccessful = orderRepository.save(order);
        if (isSuccessful) {
            return order.orderId();
        } else {
            throw new IllegalStateException("Order could not be created");
        }
    }

    public String addLine(String orderId, OrderCmd.AddLineCmd addLineCmd) {
        var order = orderRepository.get(orderId);
        order = Order.addLine(order , addLineCmd.productId(), addLineCmd.isRecurring());
        boolean isSuccessful = orderRepository.save(order);
        if (isSuccessful) {
            return order.orderId();
        } else {
            throw new IllegalStateException("Line Item could not be added");
        }
    }


    public boolean deleteLine(String orderId, String lineId){
        //remove lineID FROM ORDER.
        var order = orderRepository.get(orderId);
        order = Order.deleteLine(order , lineId);
        boolean isSuccessful = orderRepository.save(order);
        if (isSuccessful) {
            return true;
        } else {
            throw new IllegalStateException("Line Item could not be deleted");
        }
    }
}
