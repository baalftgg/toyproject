package com.example.project_toy.product.grade.controller;

import com.example.project_toy.product.grade.dto.GradeRequestDto;
import com.example.project_toy.product.grade.dto.GradeResponseDto;
import com.example.project_toy.product.grade.entity.GradeEntity;
import com.example.project_toy.product.grade.service.GradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/grade")
public class GradeController {
    private final GradeService gradeService;

    @PostMapping("/create")
    public ResponseEntity<GradeResponseDto> createGrade(@Valid @RequestBody GradeRequestDto gradeRequestDto) {
        GradeResponseDto responseDto = gradeService.createGrade(gradeRequestDto);
        return ResponseEntity.ok().body(responseDto);
    }

    @GetMapping("/list")
    public ResponseEntity<List> listGrades() {
        List<GradeEntity> grades = gradeService.listGrades();
        return ResponseEntity.ok().body(grades);
    }

    @PutMapping("/{gradeId}/update")
    public ResponseEntity<GradeResponseDto> updateGrade(@PathVariable int gradeId, @RequestBody GradeRequestDto gradeRequestDto) {
        GradeResponseDto gradeResponseDto = gradeService.updateGrade(gradeId, gradeRequestDto);
        return ResponseEntity.ok().body(gradeResponseDto);
    }

    @DeleteMapping("/{gradeId}/delete")
    public ResponseEntity deleteGrade(@PathVariable int gradeId) {
        gradeService.deleteGrade(gradeId);
        return ResponseEntity.ok().build();
    }
}
