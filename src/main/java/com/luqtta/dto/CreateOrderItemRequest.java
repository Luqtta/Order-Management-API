package com.luqtta.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public class CreateOrderItemRequest {

    @NotBlank(message = "Product name is required")
    public String productName;

    @NotNull(message = "Quantity is required")
    @Positive(message = "Quantity must be greater than zero")
    public Integer quantity;

    @NotNull(message = "Unit price is required")
    @Positive(message = "Unit price must be greater than zero")
    public BigDecimal unitPrice;
}