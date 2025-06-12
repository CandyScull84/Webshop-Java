package com.example.webshop;

import com.example.webshop.model.*;
import com.example.webshop.repository.OrderRepository;
import com.example.webshop.repository.ProductRepository;
import com.example.webshop.service.OrderService;
import com.example.webshop.exception.ProductNotFoundException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    private OrderService orderService;

    @BeforeEach
    void setUp() {
        ProductRepository productRepository = new ProductRepository();
        OrderRepository orderRepository = new OrderRepository();
        orderService = new OrderService(orderRepository, productRepository);
    }

    @Test
    void createOrderSuccess() {
        CustomerInfo customer = new CustomerInfo("Lisa", "Gatan 1", "lisa@test.com");
        List<OrderItem> items = List.of(new OrderItem(1L, 2, 0));

        Order order = orderService.createOrder(customer, items);

        assertEquals(1, order.getItems().size());
        assertEquals(2, order.getItems().get(0).getQuantity());
        assertTrue(order.getTotalAmount() > 0);
    }

    @Test
    void invalidProductThrowsException() {
        CustomerInfo customer = new CustomerInfo("Anna", "Vägen 2", "anna@test.com");
        List<OrderItem> items = List.of(new OrderItem(999L, 1, 0));

        assertThrows(ProductNotFoundException.class, () -> {
            orderService.createOrder(customer, items);
        });
    }
}
