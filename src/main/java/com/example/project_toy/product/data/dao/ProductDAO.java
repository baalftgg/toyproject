package com.example.project_toy.product.data.dao;

import com.example.project_toy.product.data.entity.Product;

public interface ProductDAO {

    Product saveProduct(Product product);

    Product getProduct(String productId);

}
