package com.eventflow.order.repo;

import com.eventflow.order.domain.Order;

import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryOrderRepository {

    private final ConcurrentHashMap<UUID, Order> storage = new ConcurrentHashMap<>();

    public Order save(Order order) {
        storage.put(order.id(), order);
        return order;
    }

    public Optional<Order> findById(UUID id) {
        return Optional.ofNullable(storage.get(id));
    }
}
