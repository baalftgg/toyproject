package com.example.project_toy.product.order.repository;

import com.example.project_toy.product.order.entitiy.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
