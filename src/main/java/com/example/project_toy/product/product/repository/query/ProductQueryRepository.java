package com.example.project_toy.product.product.repository.query;

import com.example.project_toy.product.product.dto.Product;

import java.util.List;

public interface ProductQueryRepository {
    List<Product> findByProductTypeNo(int productTypeNo);
}
