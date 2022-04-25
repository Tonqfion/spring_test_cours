package com.cours.project_spring_test.service.impl;

import com.cours.project_spring_test.exception.ResourceNotFoundException;
import com.cours.project_spring_test.exception.StockException;
import com.cours.project_spring_test.model.Product;
import com.cours.project_spring_test.service.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductServiceImpl implements ProductService {

    private final List<Product> allProducts = new ArrayList<>();

    @Override
    public List<Product> getAllProducts() {
        return allProducts;
    }

    @Override
    public Product getProductById(final Long id) throws ResourceNotFoundException {
        final Optional<Product> optProductById = allProducts.stream().filter(product -> product.getId().equals(id)).findFirst();
        if (optProductById.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        return optProductById.get();
    }

    @Override
    public Product save(final Product product) {
        if (product != null) {
            allProducts.add(product);
        }
        return product;
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
