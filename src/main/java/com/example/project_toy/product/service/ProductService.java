package com.example.project_toy.product.service;

import com.example.project_toy.product.data.dto.ProductDTO;

public interface ProductService {

    ProductDTO saveProduct(String productId, String productName, int productPrice, int productStock);

    ProductDTO getProduct(String productId);
}
