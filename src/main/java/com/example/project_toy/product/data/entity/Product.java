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
@Table(name = "product")
public class Product{

    @Id
    String id;
    String name;
    Integer price;
    Integer stock;

    public ProductDTO toDTO(){
        return ProductDTO.builder()
                .productId(id)
                .productName(name)
                .productPrice(price)
                .productStock(stock)
                .build();
    }
}
