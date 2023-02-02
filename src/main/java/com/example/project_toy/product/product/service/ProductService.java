package com.example.project_toy.product.product.service;

import com.example.project_toy.product.product.dto.ProductResponseDto;
import com.example.project_toy.product.product.dto.ProductSaveRequestDto;
import com.example.project_toy.product.product.exception.ProductNotFoundException;
import com.example.project_toy.product.product.repository.ProductRepository;
import com.example.project_toy.product.product.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional
    public ProductResponseDto registerProduct(ProductSaveRequestDto productSaveRequestDto) {
        Product product = ProductSaveRequestDto.create(productSaveRequestDto);
        Product savedProduct = productRepository.save(product);
        return ProductResponseDto.toEntity(savedProduct);
    }

    @Transactional
    public List<Product> listProducts() {
        return productRepository.findAll();
    }


    public ProductResponseDto getByProductNo(int productNo){
        Product product = productRepository.findById(productNo).orElseThrow(() -> new ProductNotFoundException());
        return ProductResponseDto.toEntity(product);
    }

    @Transactional
    public ProductResponseDto editProduct(int productNo, ProductSaveRequestDto request) {
        Product product = productRepository.getReferenceById(productNo);
        product.update(request);
        return ProductResponseDto.toEntity(product);
    }

    @Transactional
    public void deleteProduct(int productNo) {
        productRepository.deleteById(productNo);
    }
}
