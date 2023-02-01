package com.example.project_toy.product.grade.dto;

import com.example.project_toy.product.grade.entity.GradeEntity;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GradeResponseDto {
    private int id;
    private String name;
    private double discount;
    private int period;

    public static GradeResponseDto toEntity(GradeEntity gradeEntity) {
        return GradeResponseDto.builder()
                .id(gradeEntity.getId())
                .name(gradeEntity.getName())
                .discount(gradeEntity.getDiscount())
                .period(gradeEntity.getPeriod())
                .build();
    }
}
