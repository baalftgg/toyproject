package com.example.project_toy.product.member.repository;

import com.example.project_toy.product.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Integer> {
}
