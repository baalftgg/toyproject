package com.example.project_toy.product.order.controller;

import com.example.project_toy.product.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    @PutMapping("/{memberId}/{productId}")
    public String order(@PathVariable int memberId, int productId) throws ParseException {
        String msg = orderService.order(memberId, productId);
        return msg;
    }
}
