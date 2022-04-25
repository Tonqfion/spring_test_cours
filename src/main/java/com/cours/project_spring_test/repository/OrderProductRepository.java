package com.cours.project_spring_test.repository;

import com.cours.project_spring_test.model.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductRepository extends JpaRepository<OrderProduct, Long> {
}
