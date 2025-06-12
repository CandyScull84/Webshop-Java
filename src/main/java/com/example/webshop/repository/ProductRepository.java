package com.example.webshop.repository;

import com.example.webshop.model.Product;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ProductRepository {

    private final Map<Long, Product> productMap = new HashMap<>();

    public ProductRepository() {
        // Lägg till några exempelprodukter
        productMap.put(1L, new Product(
                1L,
                "Laptop",
                "Kraftfull bärbar dator med hög prestanda",
                12500,
                "https://images.unsplash.com/photo-1517336714731-489689fd1ca8",
                5
        ));

        productMap.put(2L, new Product(
                2L,
                "Mus",
                "Trådlös optisk mus med ergonomisk design",
                250,
                "https://upload.wikimedia.org/wikipedia/commons/7/71/Logitech-wireless-mouse.jpg",
                15
        ));

        productMap.put(3L, new Product(
                3L,
                "Tangentbord",
                "Tyst mekaniskt tangentbord med bakgrundsbelysning",
                650,
                "https://images.unsplash.com/photo-1587829741301-dc798b83add3",
                5
        ));

        productMap.put(4L, new Product(
                4L,
                "Kontorsstol",
                "Ergonomisk kontorsstol med justerbart ryggstöd",
                2450,
                "https://upload.wikimedia.org/wikipedia/commons/1/12/Office_chair.jpg",
                5
        ));

        productMap.put(5L, new Product(
                5L,
                "Hörlurar",
                "Trådlösa over-ear hörlurar med brusreducering",
                890,
                "https://images.unsplash.com/photo-1580894908361-967195033215",
                10
        ));


    }

    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    public Optional<Product> findById(Long id) {
        return Optional.ofNullable(productMap.get(id));
    }
}
