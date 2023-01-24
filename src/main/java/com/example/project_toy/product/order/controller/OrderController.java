package com.example.project_toy.product.order.controller;

import com.example.project_toy.product.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    @PutMapping("/{memberId}/{productId}")
    public String order(@PathVariable Map<Integer, Integer> pathVasrMap) {
        int memberId = pathVasrMap.get("memberId");
        int productId = pathVasrMap.get("productId");
        String msg = orderService.order(memberId, productId);
        return msg;
    }
}
