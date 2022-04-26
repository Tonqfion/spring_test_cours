package com.cours.project_spring_test.service.impl;

import com.cours.project_spring_test.exception.ResourceNotFoundException;
import com.cours.project_spring_test.exception.StockException;
import com.cours.project_spring_test.model.Product;
import com.cours.project_spring_test.repository.ProductRepository;
import com.cours.project_spring_test.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service("products")
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    private final List<Product> allProducts = new ArrayList<>();

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getProductById(final Long id) throws ResourceNotFoundException {
        return productRepository.findById(id);
    }

    @Override
    public Product save(final Product product) {
        return productRepository.save(product);
    }

    @Override
    public boolean isProductAvailable(final Product product, final int quantity) {
        return product.getAvailableQuantity() >= quantity;
    }

    @Override
    public void removeProduct(final Product product, final int quantity) throws StockException {
        if (!isProductAvailable(product, quantity)) {
            throw new StockException(product);
        }
        product.setAvailableQuantity(product.getAvailableQuantity() - quantity);
    }
}
