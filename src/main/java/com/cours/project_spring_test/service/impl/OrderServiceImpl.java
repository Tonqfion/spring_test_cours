package com.cours.project_spring_test.service.impl;

import com.cours.project_spring_test.model.Order;
import com.cours.project_spring_test.repository.OrderRepository;
import com.cours.project_spring_test.service.OrderService;
import com.cours.project_spring_test.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("orders")
public class OrderServiceImpl implements OrderService {

    private final List<Order> allOrders = new ArrayList<>();

    private final ProductService productService;

    private final OrderRepository orderRepository;

    public OrderServiceImpl(ProductService productService, OrderRepository orderRepository) {
        this.productService = productService;
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order create(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public void update(final Order order)  {
    }
}
