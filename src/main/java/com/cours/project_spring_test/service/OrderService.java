package com.cours.project_spring_test.service;

import com.cours.project_spring_test.exception.StockException;
import com.cours.project_spring_test.model.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAllOrders();

    Order create(final Order order);

    void update(final Order order) throws StockException;
}
