package com.example.project_toy.product.data.handler;

import com.example.project_toy.product.data.entity.Product;

public interface ProductDataHandler {

    Product saveProduct(String productId, String productName, int productPrice, int productStock);

    Product getProduct(String productId);
}
