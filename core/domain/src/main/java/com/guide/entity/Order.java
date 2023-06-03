package com.guide.entity;


import java.util.UUID;

public record Order(String orderId, String locationId, String customerId, String items, OrderStatus status) {
    public static Order createEmpty(String locationId, String customerId) {
        return new Order(UUID.randomUUID().toString(), locationId, customerId, null, OrderStatus.OPEN);
    }
}
