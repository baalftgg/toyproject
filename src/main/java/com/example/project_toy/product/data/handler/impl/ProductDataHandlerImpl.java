package com.example.project_toy.product.data.handler.impl;

import com.example.project_toy.product.data.dao.ProductDAO;
import com.example.project_toy.product.data.entity.Product;
import com.example.project_toy.product.data.handler.ProductDataHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ProductDataHandlerImpl implements ProductDataHandler {

    ProductDAO productDAO;

    @Autowired
    public ProductDataHandlerImpl(ProductDAO productDAO){
        this.productDAO = productDAO;
    }

    @Override
    public Product saveProduct(String productId, String productName, int productPrice, int productStock){
        Product product = new Product(productId, productName, productPrice, productStock);

        return productDAO.saveProduct(product);
    }

    @Override
    public Product getProduct(String productId){
        return  productDAO.getProduct(productId);
    }
}
