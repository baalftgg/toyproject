package com.example.project_toy.product.member.dto;

import com.example.project_toy.product.member.entity.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
public class MemberRequestDto {
    private String name;
    private int cash;
    private Date registdate;

    @Builder
    public MemberRequestDto(String name, int cash, Date registdate) {
        this.name = name;
        this.cash = cash;
        this.registdate = registdate;
    }

    public static Member create(MemberRequestDto requestDto) {
        return Member.builder()
                .name(requestDto.getName())
                .cash(requestDto.getCash())
                .registdate(requestDto.getRegistdate())
                .build();
    }
}
