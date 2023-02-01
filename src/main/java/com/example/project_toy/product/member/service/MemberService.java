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
        Member member = MemberRequestDto.create(memberRequestDto);
        Member savedMember = memberRepository.save(member);
        return MemberResponseDto.toEntity(savedMember);
    }


}
