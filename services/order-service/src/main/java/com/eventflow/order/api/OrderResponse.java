package com.eventflow.order.api;

import com.eventflow.order.domain.Order;
import com.eventflow.order.domain.OrderItem;
import com.eventflow.order.domain.OrderStatus;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public record OrderResponse(
        UUID id,
        String customerId,
        List<OrderItem> items,
        OrderStatus status,
        Instant createdAt
) {
    public static OrderResponse from(Order order) {
        return new OrderResponse(
                order.id(),
                order.customerId(),
                order.items(),
                order.status(),
                order.createdAt()
        );
    }
}
