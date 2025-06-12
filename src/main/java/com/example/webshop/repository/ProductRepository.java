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
                "https://freepngdownload.com/image/laptop-png-free-download-30.png",
                5
        ));

        productMap.put(2L, new Product(
                2L,
                "Mus",
                "Trådlös optisk mus med ergonomisk design",
                250,
                "https://freepngdownload.com/image/thumb/computer-mouse-png-free-download-27.png",
                15
        ));

        productMap.put(3L, new Product(
                3L,
                "Tangentbord",
                "Tyst mekaniskt tangentbord med bakgrundsbelysning",
                650,
                "https://freepngdownload.com/image/key-board-png-free-download-21.png",
                5
        ));

        productMap.put(4L, new Product(
                4L,
                "Kontorsstol",
                "Ergonomisk kontorsstol med justerbart ryggstöd",
                2450,
                "https://freepngdownload.com/image/chair-png-free-image-download-28.png",
                5
        ));

        productMap.put(5L, new Product(
                5L,
                "Hörlurar",
                "Trådlösa over-ear hörlurar med brusreducering",
                890,
                "https://freepngdownload.com/image/head-phones-png-free-image-download-3.png",
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
