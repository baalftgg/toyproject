package com.example.project_toy.product.product.dto;

import com.example.project_toy.product.product.entity.Product;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProductResponseDto {

    private int num;
    private String name;
    private int price;
    private int stock;

    public static ProductResponseDto toEntity(Product product) {
        return ProductResponseDto.builder()
                .num(product.getNum())
                .name(product.getName())
                .price(product.getPrice())
                .stock(product.getStock())
                .build();
    }
}
