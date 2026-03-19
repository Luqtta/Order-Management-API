package com.luqtta.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public class CreateOrderRequest {

    @NotBlank(message = "Customer name is required")
    public String customerName;

    @NotBlank(message = "Customer email is required")
    @Email(message = "Customer email must be valid")
    public String customerEmail;

    @NotEmpty(message = "Order must have at least one item")
    public List<@Valid CreateOrderItemRequest> items;
}