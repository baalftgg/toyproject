package com.example.project_toy.product.data.dto;

import com.example.project_toy.product.data.entity.Product;
import lombok.*;

import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO {

    @NotNull
    private String productId;

    @NotNull
    @Id
    private String productName;

    @NotNull
    @Min(value = 0)
    @Max(value = 3000000)
    private int productPrice;

    @NotNull
    @Min(value = 0)
    @Max(value = 10000)
    private int productStock;

    public Product toEntity(){
        return Product.builder()
                .productId(productId)
                .productName(productName)
                .productPrice(productPrice)
                .productStock(productStock)
                .build();
    }

}
