package com.guide;

import com.guide.entity.Order;

public interface OrderRepository {

    boolean save(Order order);

    Order get(String orderId);
}
