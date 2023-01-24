package com.example.project_toy.product.order.service;

import com.example.project_toy.product.member.entity.Member;
import com.example.project_toy.product.member.repository.MemberRepository;
import com.example.project_toy.product.order.repository.OrderRepository;
import com.example.project_toy.product.product.entity.Product;
import com.example.project_toy.product.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {

    private final ProductRepository productRepository;

    private final MemberRepository memberRepository;

    private final OrderRepository orderRepository;

    public String order(int memberid, int productid) {
        Member member = memberRepository.getReferenceById(memberid);
        Product product = productRepository.getReferenceById(productid);

        String grade = member.getGrade();
        double discount = 1;

        if (grade.equals("bronze")){
            discount = 1;
        } else if (grade.equals("silver")) {
            discount = 0.95;
        } else if (grade.equals("gold")) {
            discount = 0.9;
        }

        int restcash = (int) Math.round(member.getCash() - (product.getPrice() * discount));

        String msg = "";

        if (restcash < 0) {
            msg = "잔액부족";
        } else {
            msg = "주문성공";
            member.order(restcash);
            product.order();
        }

        return msg;
    }
}
