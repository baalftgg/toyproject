package com.example.project_toy.product.product.entity;

import com.example.project_toy.product.product.dto.Product;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "product")
@EntityListeners(AuditingEntityListener.class)
public class ProductEntity {

    @Id
    @Column(name = "product_no")
    private int No;

    @Column(name = "product_name")
    private String Name;

    @Column(name = "product_type_no")
    private int TypeNo;

    @Column(name = "product_price")
    private int Price;

    @Column(name = "register_datetime", nullable = false)
    private LocalDateTime registerDatetime;


    public Product toProduct(){
        return Product.builder()
                .productNo(No)
                .productName(Name)
                .productTypeNo(TypeNo)
                .productPrice(Price)
                .productRT(registerDatetime)
                .build();
    }
}
