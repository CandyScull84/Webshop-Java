package com.example.webshop.controller;

import com.example.webshop.model.CustomerInfo;
import com.example.webshop.model.Order;
import com.example.webshop.model.OrderItem;
import com.example.webshop.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public Map<String, String> createOrder(@RequestBody OrderRequest orderRequest) {
        Order order = orderService.createOrder(orderRequest.getCustomerInfo(), orderRequest.getItems());

        return Map.of(
                "orderId", order.getId(),
                "message", "Order skapad!"
        );
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    public static class OrderRequest {
        private CustomerInfo customerInfo;
        private List<OrderItem> items;

        public CustomerInfo getCustomerInfo() {
            return customerInfo;
        }

        public void setCustomerInfo(CustomerInfo customerInfo) {
            this.customerInfo = customerInfo;
        }

        public List<OrderItem> getItems() {
            return items;
        }

        public void setItems(List<OrderItem> items) {
            this.items = items;
        }
    }
}
