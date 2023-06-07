package com.guide.entity;


import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public record Order(String orderId, String locationId, String customerId, List<LineItem> items, OrderStatus status) {
    public static Order createEmpty(String locationId, String customerId) {
        return new Order(UUID.randomUUID().toString(), locationId, customerId, new LinkedList<>(), OrderStatus.OPEN);
    }

    public static Order addLine(Order order , String productId, boolean isRecurring) {
        var lineItem = new LineItem(UUID.randomUUID().toString(), productId, isRecurring);
        order.items().add(lineItem);
        //copy order
        return new Order(order.orderId(),
                        order.locationId(),
                        order.customerId(),
                        order.items(),
                        order.status());
    }

    public static Order deleteLine(Order order , String lineId) {
        order.items().stream()
                .filter(item -> item.lineId().equals(lineId)).forEach(item -> order.items().remove(item));
        return new Order(order.orderId(),
                        order.locationId(),
                        order.customerId(),
                        order.items(),
                        order.status());
    }
}
