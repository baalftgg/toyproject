package com.example.project_toy.product.data.repository;

import com.example.project_toy.product.data.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {

}
