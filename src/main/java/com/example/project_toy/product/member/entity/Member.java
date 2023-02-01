package com.example.project_toy.product.member.entity;

import com.example.project_toy.product.member.dto.MemberRequestDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "member")
public class Member {

    @Id
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int num;

    @Column(name = "member_name", nullable = false)
    private String name;

    private int cash;

    private Date registdate;


    public void order(int restcash) {
        this.cash = restcash;
    }
}
