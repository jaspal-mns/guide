package com.guide;

import com.guide.entity.Order;
import jakarta.inject.Singleton;

import java.util.HashMap;
import java.util.Map;

@Singleton
public class OrderRepositoryImpl implements OrderRepository{

    private final Map<String, Order> ordersStorage= new HashMap<>();
    @Override
    public boolean save(Order order) {
        ordersStorage.put(order.orderId(), order);
        return true;
    }

    @Override
    public Order get(String orderId) {
        return ordersStorage.get(orderId);
    }
}
