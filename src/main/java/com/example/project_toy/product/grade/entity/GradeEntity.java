package com.example.project_toy.product.grade.entity;

import com.example.project_toy.product.grade.dto.GradeRequestDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "grade")
public class GradeEntity {

    @Id
    @Column(name = "Grade_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private double discount;

    @Column(name = "Grade_period")
    private int period;

    public void update(GradeRequestDto requestDto) {
        this.name = requestDto.getName();
        this.discount = requestDto.getDiscount();
        this.period = requestDto.getPeriod();
    }
}
