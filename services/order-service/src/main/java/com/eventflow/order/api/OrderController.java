package com.eventflow.order.api;

import com.eventflow.order.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping
    public OrderResponse create(@Valid @RequestBody CreateOrderRequest req) {
        return OrderResponse.from(service.create(req));
    }

    @GetMapping("/{id}")
    public OrderResponse get(@PathVariable UUID id) {
        return OrderResponse.from(service.get(id));
    }
}
