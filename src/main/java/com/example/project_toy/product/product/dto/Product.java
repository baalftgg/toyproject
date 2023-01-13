package com.example.project_toy.product.product.dto;


import com.example.project_toy.product.product.entity.ProductEntity;
import lombok.*;

import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @NotNull
    @Id
    private int productNo;
    @NotNull
    private String productName;
    @NotNull
    private int productTypeNo;
    @NotNull
    @Min(value = 0)
    @Max(value = 3000000)
    private int productPrice;
    @NotNull
    private LocalDateTime productRT;

    public ProductEntity toEntity(){
        return ProductEntity.builder()
                .No(productNo)
                .Name(productName)
                .TypeNo(productTypeNo)
                .Price(productPrice)
                .registerDatetime(productRT)
                .build();
    }

}
