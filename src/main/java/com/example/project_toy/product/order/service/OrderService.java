package com.example.project_toy.product.order.service;

import com.example.project_toy.product.grade.entity.GradeEntity;
import com.example.project_toy.product.grade.repository.GradeRepository;
import com.example.project_toy.product.member.entity.Member;
import com.example.project_toy.product.member.repository.MemberRepository;
import com.example.project_toy.product.product.entity.Product;
import com.example.project_toy.product.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {

    private final ProductRepository productRepository;
    private final MemberRepository memberRepository;
    private final GradeRepository gradeRepository;

    public long calcperiod(int memberid) throws ParseException {
        Member member = memberRepository.getReferenceById(memberid);

        String nowdatestring = "20231231";
        DateFormat format = new SimpleDateFormat(("yyyyMMdd"));

        Date nowdate = format.parse(nowdatestring);
        long diffDays = (nowdate.getTime() - member.getRegistdate().getTime()) / (1000*24*60*60);

        return diffDays;
    }

    public GradeEntity grading(long period) {

        List<GradeEntity> gradeEntityList = gradeRepository.findAll(Sort.by(Sort.Direction.ASC,"period"));

        GradeEntity grade = gradeEntityList.get(0);

        for(int i=0; i < gradeEntityList.size(); i++) {
            if (period >= gradeEntityList.get(i).getPeriod()) {
                grade = gradeEntityList.get(i);
            }
            else {
                break;
            }
        }

        return grade;
    }

    public String order(int memberid, int productid) throws ParseException {
        Member member = memberRepository.getReferenceById(memberid);
        Product product = productRepository.getReferenceById(productid);
        long period = calcperiod(memberid);
        GradeEntity grade = grading(period);
        double discount = grade.getDiscount();

        double finalprice = product.getPrice() * discount;
        int restcash = (int) Math.round(member.getCash() - finalprice);

        String msg = "";

        if (restcash < 0) {
            msg = "잔액부족";
        } else {
            msg = product.getName() + " " + finalprice + "결제완료";
            member.order(restcash);
            product.order();
        }

        return msg;
    }
}
