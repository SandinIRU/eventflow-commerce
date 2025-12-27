package com.eventflow.order.api;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record CreateOrderItemRequest(
        @NotBlank String sku,
        @Min(1) int quantity
) {}
