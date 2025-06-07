package com.example.webshop.repository;

import com.example.webshop.model.Product;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ProductRepository {

    private final Map<Long, Product> productMap = new HashMap<>();

    public ProductRepository() {
        // Lägg till några exempelprodukter
        productMap.put(1L, new Product(1L, "Laptop", "Kraftfull bärbar dator", 9999.99, "", 5));
        productMap.put(2L, new Product(2L, "Mus", "Trådlös mus", 299.99, "", 15));
    }

    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    public Optional<Product> findById(Long id) {
        return Optional.ofNullable(productMap.get(id));
    }
}
