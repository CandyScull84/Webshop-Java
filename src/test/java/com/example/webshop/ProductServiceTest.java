package com.example.webshop;

import com.example.webshop.model.Product;
import com.example.webshop.repository.ProductRepository;
import com.example.webshop.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceTest {

    private ProductService productService;

    @BeforeEach
    void setUp() {
        ProductRepository productRepository = new ProductRepository(); // in-memory
        productService = new ProductService(productRepository);
    }

    @Test
    void testGetAllProductsReturnsList() {
        List<Product> products = productService.getAllProducts();
        assertFalse(products.isEmpty(), "Produktlistan ska inte vara tom");
    }

    @Test
    void testGetProductByIdReturnsCorrectProduct() {
        Product product = productService.getProductById(1L);
        assertEquals(1L, product.getId());
        assertEquals("Laptop", product.getName());
    }

    @Test
    void testGetProductByIdThrowsException() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            productService.getProductById(999L);
        });

        String expected = "Produkt med ID 999 hittades inte.";
        assertEquals(expected, exception.getMessage());
    }
}
