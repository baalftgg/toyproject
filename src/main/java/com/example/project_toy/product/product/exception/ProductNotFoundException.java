package com.example.project_toy.product.product.exception;

import javax.persistence.EntityNotFoundException;

public class ProductNotFoundException extends EntityNotFoundException {
    public ProductNotFoundException() {
        super("존재하지 않는 제품번호입니다.");
    }
}
