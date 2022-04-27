package com.cours.project_spring_test.controller;

import com.cours.project_spring_test.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = { "", "/"})
    public String getProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        System.out.println("/products : get all products");
        return "products";
    }

    @GetMapping("/{productId}")
    public String getProductById(Model model, @PathVariable("productId") Long id) {
        System.out.println("/products/id : get product by id (" + id + ")");
        model.addAttribute("product", productService.getProductById(id));
        return "product";
    }
}
