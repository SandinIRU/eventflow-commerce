package com.eventflow.order.domain;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public record Order(
        UUID id,
        String customerId,
        List<OrderItem> items,
        OrderStatus status,
        Instant createdAt
) {}
