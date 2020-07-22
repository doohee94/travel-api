package com.example.demo.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 *  QueryDsl Configuration
 *  - queryDsl 기능을 위한 Configuration
 *
 * @createBy DO
 * @Date 2020.06.13
 * */
@Configuration
public class QueryDslConfig {

    @PersistenceContext
    private EntityManager entityManager;

    @Bean
    public JPAQueryFactory jpaQueryFactory(){return  new JPAQueryFactory(entityManager);}

}
