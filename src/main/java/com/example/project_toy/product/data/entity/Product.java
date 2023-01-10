package com.example.project_toy.product.data.entity;

import com.example.project_toy.product.data.dto.ProductDTO;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Table(name = "product")
public class Product {

    @Id
    String productId;
    String productName;
    Integer productPrice;
    Integer productStock;

//    public ProductDTO toDTO(){
//        return ProductDTO.builder()
//                .productId(ProductId)
//                .productName(ProductName)
//                .productPrice(ProductPrice)
//                .productStock(ProductStock)
//                .build();
//    }
}
