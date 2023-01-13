package com.example.project_toy.product.product.service;

import com.example.project_toy.product.product.dto.Product;
import com.example.project_toy.product.product.repository.ProductRepository;
import com.example.project_toy.product.product.entity.ProductEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }


    public Product addProduct(int No, String Name, int TypeNo, int Price, LocalDateTime registerDateTime){
        ProductEntity productEntity = new ProductEntity(No, Name, TypeNo, Price, registerDateTime);
        productRepository.save(productEntity);
        Product product = new Product(productEntity.getNo(), productEntity.getName(), productEntity.getTypeNo(), productEntity.getPrice(), productEntity.getRegisterDatetime());

        return product;
    }

    public List<ProductEntity> listProducts() {
        return productRepository.findAll();
    }

    public Product getByProductNo(int productNo){
        ProductEntity productEntity = productRepository.getById(productNo);
        Product product = new Product(productEntity.getNo(), productEntity.getName(), productEntity.getTypeNo(), productEntity.getPrice(), productEntity.getRegisterDatetime());
        return product;
    }

//    public int edit(productNo, product){
//        ProductEntity productEntity = productRepository.findById()
//    }

    public void deleteProduct(int productNo) {
        productRepository.deleteById(productNo);
    }


}
