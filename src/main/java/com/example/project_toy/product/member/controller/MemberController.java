package com.example.project_toy.product.member.controller;

import com.example.project_toy.product.member.dto.MemberRequestDto;
import com.example.project_toy.product.member.dto.MemberResponseDto;
import com.example.project_toy.product.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/signin")
    public ResponseEntity<MemberResponseDto> signinMember(@RequestBody MemberRequestDto memberRequestDto) throws ParseException {
        MemberResponseDto responseDto = memberService.signinMember(memberRequestDto);
        return ResponseEntity.ok().body(responseDto);
    }
}

