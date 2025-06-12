package com.example.webshop.service;

import com.example.webshop.model.*;
import com.example.webshop.repository.OrderRepository;
import com.example.webshop.repository.ProductRepository;
import org.springframework.stereotype.Service;
import com.example.webshop.exception.ProductNotFoundException;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public OrderService(OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    public Order createOrder(CustomerInfo customerInfo, List<OrderItem> requestedItems) {
        List<OrderItem> validItems = new ArrayList<>();
        double total = 0;

        for (OrderItem item : requestedItems) {
            Product product = productRepository.findById(item.getProductId())
                    .orElseThrow(() -> new ProductNotFoundException(item.getProductId()));



            double price = product.getPrice();
            int quantity = item.getQuantity();

            validItems.add(new OrderItem(product.getId(), quantity, price));
            total += price * quantity;
        }

        Order order = new Order(customerInfo, validItems, total);
        orderRepository.save(order);
        return order;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

}
