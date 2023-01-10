package com.example.project_toy.product.controller;

import com.example.project_toy.product.data.dto.ProductDTO;
import com.example.project_toy.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }
    @GetMapping("/{productId}")
    public ProductDTO getProduct(@PathVariable String productId){

        ProductDTO productDTO = productService.getProduct(productId);

        return productDTO;
    }

    @PostMapping("/register")
    public ResponseEntity<ProductDTO> createProduct(@Valid @RequestBody ProductDTO productDTO){

        String productId = productDTO.getProductId();
        String productName = productDTO.getProductName();
        int productPrice = productDTO.getProductPrice();
        int productStock = productDTO.getProductStock();

        ProductDTO response = productService.saveProduct(productId, productName, productPrice, productStock);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{productId}")
    public ProductDTO deleteProduct(@PathVariable String productId){
        return null;
    }
}
