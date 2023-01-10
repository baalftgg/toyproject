package com.example.project_toy.product.service.impl;

import com.example.project_toy.product.data.dto.ProductDTO;
import com.example.project_toy.product.data.entity.Product;
import com.example.project_toy.product.data.handler.ProductDataHandler;
import com.example.project_toy.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    ProductDataHandler productDataHandler;

    @Autowired
    public  ProductServiceImpl(ProductDataHandler productDataHandler){
        this.productDataHandler = productDataHandler;
    }

    @Override
    public ProductDTO saveProduct(String productId, String productName, int productPrice, int productStock){
        Product product = productDataHandler.saveProduct(productId, productName, productPrice, productStock);

        ProductDTO productDTO = new ProductDTO(product.getId(),
                product.getName(), product.getPrice(), product.getStock());

        return productDTO;
    }

    @Override
    public ProductDTO getProduct(String productId){
        Product product = productDataHandler.getProduct(productId);

        ProductDTO productDTO = new ProductDTO(product.getId(),
                product.getName(), product.getPrice(), product.getStock());

        return productDTO;
    }
}
