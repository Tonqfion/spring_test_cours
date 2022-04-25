package com.cours.project_spring_test.service.impl;

import com.cours.project_spring_test.exception.StockException;
import com.cours.project_spring_test.model.Order;
import com.cours.project_spring_test.model.OrderProduct;
import com.cours.project_spring_test.service.OrderService;
import com.cours.project_spring_test.service.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderServiceImpl implements OrderService {

    private final List<Order> allOrders = new ArrayList<>();

    private ProductService productService;

    @Override
    public List<Order> getAllOrders() {
        return allOrders;
    }

    @Override
    public Order create(Order order) {
        if (order != null) {
            order.setStatus("En cours");
            allOrders.add(order);
        }
         return order;
    }

    @Override
    public void update(final Order order) throws StockException  {
        if (!order.getStatus().equals("Payé")) {
            final Optional<OrderProduct> orderProductNotAvailableOptional = order.getOrderProductsList().stream().filter(orderProduct -> !productService.isProductAvailable(orderProduct.getProduct(), orderProduct.getQuantity())).findAny();

            if (orderProductNotAvailableOptional.isPresent()) {
                throw new StockException(orderProductNotAvailableOptional.get().getProduct());
            }

            for (final OrderProduct orderProduct : order.getOrderProductsList()) {
                productService.removeProduct(orderProduct.getProduct(), orderProduct.getQuantity());
            }
            order.setStatus("Payé");
        }
    }

    public void setProductService(ProductServiceImpl productService) {
        this.productService = productService;
    }

    public ProductService getProductService() {
        return productService;
    }
}
