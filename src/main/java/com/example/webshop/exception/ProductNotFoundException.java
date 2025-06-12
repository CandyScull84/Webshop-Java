package com.example.webshop.exception;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(Long productId) {
        super("Produkt med ID " + productId + " hittades inte.");
    }
}
