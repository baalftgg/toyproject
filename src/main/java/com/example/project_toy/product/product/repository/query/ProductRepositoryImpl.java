package com.example.project_toy.product.product.repository.query;

import com.example.project_toy.product.product.dto.Product;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.example.project_toy.product.product.entity.ProductEntity;
import com.saltlux.demo.product.entity.QProductEntity;
import com.saltlux.demo.product.entity.QProductTypeEntity;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class ProductRepositoryImpl extends QuerydslRepositorySupport implements ProductQueryRepository {
    private final JPAQueryFactory queryFactory;
    private QProductEntity productEntity = QProductEntity.productEntity;
    private QProductTypeEntity productTypeEntity = QProductTypeEntity.productTypeEntity;


    public ProductRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        super(ProductEntity.class);
        this.queryFactory = jpaQueryFactory;
    }

    @Override
    public List<Product> findByProductTypeNo(int productTypeNo){
        List<Product> details =queryFactory.from(productEntity)
                .select(Projections.fields(Product.class, productEntity.productName,
                        productEntity.productPrice,
                        productTypeEntity.productTypeName.as("productTypeName")))
                .innerJoin(productTypeEntity).on(productEntity.productTypeNo.eq(productTypeEntity.productTypeNo))
                .where(productEntity.productTypeNo.eq(productTypeNo))
                .fetch();
        return details;
    }
}
