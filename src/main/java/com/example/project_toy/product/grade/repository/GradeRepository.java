package com.example.project_toy.product.grade.repository;

import com.example.project_toy.product.grade.entity.GradeEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface GradeRepository extends JpaRepository <GradeEntity, Integer> {

}
