package com.cours.project_spring_test.controller;

import com.cours.project_spring_test.model.Product;
import com.cours.project_spring_test.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(final ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable(value = "id") Long id) {
        Optional<Product> optionalProduct = productService.getProductById(id);
        return optionalProduct.map(product -> ResponseEntity.ok().body(product)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/save")
    public Product saveProduct(@RequestParam("name") String name, //
                               @RequestParam("description") String description, //
                               @RequestParam("price") Double price, //
                               @RequestParam("availableQuantity") Integer availableQuantity, //
                               @RequestParam("picture") String picture
                               ) {
        final Product newProduct = new Product();
        newProduct.setName(name);
        newProduct.setDescription(description);
        newProduct.setPrice(price);
        newProduct.setAvailableQuantity(availableQuantity);
        newProduct.setPicture(picture);
        return productService.save(newProduct);
    }
}
