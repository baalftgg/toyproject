package com.example.project_toy.product.product.controller;

import com.example.project_toy.product.product.dto.ProductResponseDto;
import com.example.project_toy.product.product.entity.Product;
import com.example.project_toy.product.product.dto.ProductSaveRequestDto;
import com.example.project_toy.product.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @PostMapping("/register")
    public ResponseEntity<ProductResponseDto> createProduct(@Valid @RequestBody ProductSaveRequestDto productSaveRequestDto) {

        ProductResponseDto response = productService.registerProduct(productSaveRequestDto);

        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/list")
    public ResponseEntity<List> listProducts() {
        List<Product> product = productService.listProducts();
        return ResponseEntity.ok().body(product);
    }

    @GetMapping("/{productNo}/search")
    public ResponseEntity<ProductResponseDto> getByProductNo(@PathVariable int productNo) {
        ProductResponseDto productResponseDto = productService.getByProductNo(productNo);
        return ResponseEntity.ok().body(productResponseDto);
    }

    @PutMapping("/{productNo}/edit")
    public ResponseEntity<ProductResponseDto> editProduct(@PathVariable int productNo, @RequestBody ProductSaveRequestDto productSaveRequestDto) {
        ProductResponseDto productResponseDto = productService.editProduct(productNo, productSaveRequestDto);
        return ResponseEntity.ok().body(productResponseDto);
    }

    @DeleteMapping("/{productNo}/delete")
    public ResponseEntity deleteProduct(@PathVariable int productId) {
        productService.deleteProduct(productId);
        return ResponseEntity.ok().build();
    }

}
