package com.example.project_toy.product.product.dto;

import com.example.project_toy.product.product.entity.Product;
import lombok.*;

@Getter
@NoArgsConstructor
public class ProductSaveRequestDto {
    private String name;
    private int price;
    private int stock;

    @Builder
    public ProductSaveRequestDto(String name, int price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public static Product create(ProductSaveRequestDto request) {
        return Product.builder()
                .name(request.getName())
                .price(request.getPrice())
                .stock(request.getStock())
                .build();
    }

}
