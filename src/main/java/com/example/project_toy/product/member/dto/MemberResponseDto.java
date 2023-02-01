package com.example.project_toy.product.member.dto;

import com.example.project_toy.product.member.entity.Member;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
@Builder
public class MemberResponseDto {

    private int num;
    private String name;
    private int cash;
    private Date registdate;

    public static MemberResponseDto toEntity(Member member) {
        return MemberResponseDto.builder()
                .num(member.getNum())
                .name(member.getName())
                .cash(member.getCash())
                .registdate(member.getRegistdate())
                .build();
    }
}
