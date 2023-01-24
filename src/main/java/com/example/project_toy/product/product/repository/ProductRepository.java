package com.example.project_toy.product.product.repository;

import com.example.project_toy.product.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
