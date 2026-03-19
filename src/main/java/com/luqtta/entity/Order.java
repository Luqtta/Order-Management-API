package com.luqtta.entity;

import com.luqtta.domain.OrderStatus;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "customer_name", nullable = false, length = 100)
    public String customerName;

    @Column(name = "customer_email", nullable = false, length = 150)
    public String customerEmail;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    public OrderStatus status;

    @Column(name = "total_amount", nullable = false, precision = 12, scale = 2)
    public BigDecimal totalAmount;

    @Column(name = "created_at", nullable = false)
    public LocalDateTime createdAt;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<OrderItem> items = new ArrayList<>();

    public Order() {
        this.status = OrderStatus.CREATED;
        this.createdAt = LocalDateTime.now();
        this.totalAmount = BigDecimal.ZERO;
    }

    public void addItem(OrderItem item) {
        item.order = this;
        this.items.add(item);
        this.calculateTotal();
    }

    public void removeItem(OrderItem item) {
        this.items.remove(item);
        item.order = null;
        this.calculateTotal();
    }

    public void calculateTotal() {
        this.totalAmount = this.items.stream()
                .map(item -> item.unitPrice.multiply(BigDecimal.valueOf(item.quantity)))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}