package com.cours.project_spring_test.service;

import com.cours.project_spring_test.exception.ResourceNotFoundException;
import com.cours.project_spring_test.exception.StockException;
import com.cours.project_spring_test.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getAllProducts();
    Optional<Product> getProductById(final Long id) throws ResourceNotFoundException;
    Product save(final Product product);
    boolean isProductAvailable(final Product product, final int quantity);
    void removeProduct(final Product product, int quantity) throws StockException;
}
