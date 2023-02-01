package com.example.project_toy.product.grade.dto;

import com.example.project_toy.product.grade.entity.GradeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GradeRequestDto {
    private String name;
    private double discount;
    private int period;

    @Builder
    public GradeRequestDto(String name, double discount, int period) {
        this.name = name;
        this.discount = discount;
        this.period = period;
    }

    public static GradeEntity create(GradeRequestDto requestDto) {
        return GradeEntity.builder()
                .name(requestDto.getName())
                .discount(requestDto.getDiscount())
                .period(requestDto.getPeriod())
                .build();
    }
}
