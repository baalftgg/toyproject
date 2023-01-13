package com.example.project_toy.product.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

//    private final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);
    @GetMapping("/hello")
    public String hello(){
        return "안녕!";
    }

//    @PostMapping("log-test")
}

