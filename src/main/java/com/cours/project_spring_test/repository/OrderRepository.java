package com.cours.project_spring_test.repository;

import com.cours.project_spring_test.model.Order;
import com.cours.project_spring_test.model.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
