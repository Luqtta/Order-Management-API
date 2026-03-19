package com.luqtta.service;

import com.luqtta.dto.CreateOrderItemRequest;
import com.luqtta.dto.CreateOrderRequest;
import com.luqtta.entity.Order;
import com.luqtta.entity.OrderItem;
import com.luqtta.exception.ResourceNotFoundException;
import io.quarkus.panache.common.Page;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class OrderService {

    @Transactional
    public Order createOrder(CreateOrderRequest request) {
        Order order = new Order();

        order.customerName = request.customerName;
        order.customerEmail = request.customerEmail;

        for (CreateOrderItemRequest itemRequest : request.items) {
            OrderItem item = new OrderItem();
            item.productName = itemRequest.productName;
            item.quantity = itemRequest.quantity;
            item.unitPrice = itemRequest.unitPrice;


            order.addItem(item);
        }

        order.persist();

        return order;
    }

    public Order findById(Long orderId) {
        Order order = Order.findById(orderId);

        if (order == null) {
            throw new ResourceNotFoundException("Order with id " + orderId + " not found");
        }

        return order;
    }

    public List<Order> findAll(int page, int size) {
        return Order.findAll()
                .page(Page.of(page, size))
                .list();
    }
}