package com.example.project_toy.product.data.dao.impl;

import com.example.project_toy.product.data.dao.ProductDAO;
import com.example.project_toy.product.data.entity.Product;
import com.example.project_toy.product.data.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductDAOImpl implements ProductDAO {

    ProductRepository productRepository;

    @Autowired
    public ProductDAOImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public Product saveProduct(Product product){
        productRepository.save(product);
        return product;
    }

    @Override
    public Product getProduct(String productId){
        Product product = productRepository.getById(productId);
        return product;
    }
}
