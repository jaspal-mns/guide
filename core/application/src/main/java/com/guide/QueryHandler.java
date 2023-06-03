package com.guide;

import com.guide.entity.Order;
import jakarta.inject.Singleton;
import lombok.AllArgsConstructor;

@Singleton
@AllArgsConstructor
public class QueryHandler {

    OrderRepository orderRepository;
    Order handle(String orderId) {
        return orderRepository.get(orderId);
    }
}
