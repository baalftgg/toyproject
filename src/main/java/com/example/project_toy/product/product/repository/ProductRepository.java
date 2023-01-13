package com.example.project_toy.product.product.repository;

import com.example.project_toy.product.product.repository.query.ProductQueryRepository;
import com.example.project_toy.product.product.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity,Integer>, ProductQueryRepository {
}
