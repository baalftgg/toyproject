package com.example.project_toy.product.grade.service;

import com.example.project_toy.product.grade.dto.GradeRequestDto;
import com.example.project_toy.product.grade.dto.GradeResponseDto;
import com.example.project_toy.product.grade.entity.GradeEntity;
import com.example.project_toy.product.grade.repository.GradeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class GradeService {

    private final GradeRepository gradeRepository;

    public GradeResponseDto createGrade(GradeRequestDto gradeRequestDto) {
        GradeEntity gradeEntity = GradeRequestDto.create(gradeRequestDto);
        GradeEntity saveGradeEntity = gradeRepository.save(gradeEntity);
        return GradeResponseDto.toEntity(gradeEntity);
    }

    public List<GradeEntity> listGrades() { return gradeRepository.findAll(Sort.by(Sort.Direction.ASC,"period")); }

    public  GradeResponseDto updateGrade(int gradeId, GradeRequestDto requestDto) {
        GradeEntity grade = gradeRepository.getReferenceById(gradeId);
        grade.update(requestDto);
        return GradeResponseDto.toEntity(grade);
    }

    public void deleteGrade(int gradeId) { gradeRepository.deleteById(gradeId); }
}
