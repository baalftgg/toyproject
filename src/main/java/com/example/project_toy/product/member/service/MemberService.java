package com.example.project_toy.product.member.service;

import com.example.project_toy.product.member.dto.MemberRequestDto;
import com.example.project_toy.product.member.dto.MemberResponseDto;
import com.example.project_toy.product.member.entity.Member;
import com.example.project_toy.product.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberResponseDto signinMember(MemberRequestDto memberRequestDto) throws ParseException {
        String grade = grading(memberRequestDto);
        Member member = MemberRequestDto.create(memberRequestDto, grade);
        Member savedMember = memberRepository.save(member);
        return MemberResponseDto.toEntity(savedMember);
    }

    public String grading(MemberRequestDto requestDto) throws ParseException {
        String grade = "bronze";

        String nowdatestring = "20231231";
        DateFormat format = new SimpleDateFormat(("yyyyMMdd"));

        Date nowdate = format.parse(nowdatestring);
        long diffDays = (nowdate.getTime() - requestDto.getRegistdate().getTime()) / (1000*24*60*60);

        if (diffDays > 10 && diffDays <= 20) {
            grade = "silver";
        }else if(diffDays > 20) {
            grade = "gold";
        }

        return grade;
    }

}
