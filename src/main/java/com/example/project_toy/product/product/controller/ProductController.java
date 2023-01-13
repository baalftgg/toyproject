package com.example.project_toy.product.product.controller;

import com.example.project_toy.product.product.entity.ProductEntity;
import com.example.project_toy.product.product.dto.Product;
import com.example.project_toy.product.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping("/register")
    public ResponseEntity<Product> createProduct(@Valid @RequestBody Product product){

        Product response = productService.addProduct();

        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/list")
    public ResponseEntity<List> listProducts() {
        List<ProductEntity> product = productService.listProducts();
        return ResponseEntity.ok().body(product);
    }

    @GetMapping("/{productNo}/search")
    public Product getByProductNo(@PathVariable int productNo){
        Product product = productService.getByProductNo(productNo);
        return product;
    }

//    @ApiOperation(value = "제품 수정")
//    @PutMapping("/{productNo}/edit")
//    public ResponseEntity<ProductEntity> editProduct(@RequestBody Product productupdate, @PathVariable int productNo){
//        Optional<ProductEntity> product = this.productService.edit(productNo, productupdate);
//        return ResponseEntity.ok().body(product);
//    }

    @DeleteMapping("/{productNo}/delete")
    public ResponseEntity deleteProduct(@PathVariable int productId){
        productService.deleteProduct(productId);
        return ResponseEntity.ok().build();
    }

}
