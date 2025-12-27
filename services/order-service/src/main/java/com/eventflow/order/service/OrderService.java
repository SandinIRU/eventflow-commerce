package com.eventflow.order.service;

import com.eventflow.order.api.CreateOrderRequest;
import com.eventflow.order.domain.Order;
import com.eventflow.order.domain.OrderItem;
import com.eventflow.order.domain.OrderStatus;
import com.eventflow.order.errors.NotFoundException;
import com.eventflow.order.repo.InMemoryOrderRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    private final InMemoryOrderRepository repo = new InMemoryOrderRepository();

    public Order create(CreateOrderRequest req) {
        UUID id = UUID.randomUUID();

        List<OrderItem> items = req.items().stream()
                .map(i -> new OrderItem(i.sku(), i.quantity()))
                .toList();

        Order order = new Order(
                id,
                req.customerId(),
                items,
                OrderStatus.CREATED,
                Instant.now()
        );

        return repo.save(order);
    }

    public Order get(UUID id) {
        return repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Order not found: " + id));
    }
}
