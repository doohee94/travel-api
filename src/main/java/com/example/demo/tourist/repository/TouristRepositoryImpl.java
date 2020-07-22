package com.example.demo.tourist.repository;

import com.example.demo.tourist.entity.QTourist;
import com.example.demo.tourist.entity.Tourist;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

@Repository
public class TouristRepositoryImpl extends QuerydslRepositorySupport implements TouristRepositoryCustom {

    private JPAQueryFactory queryFactory;

    public TouristRepositoryImpl( JPAQueryFactory queryFactory) {
        super(Tourist.class);
        this.queryFactory = queryFactory;
    }


    @Override
    public Page<Tourist> findByType(String type, String keyword, Pageable pageable) {

        JPAQuery<Tourist> query = queryFactory.selectFrom(QTourist.tourist);

        if(type != null && keyword != null){
            query = getWhereQuery(type, keyword, query);
        }
        Long totalSize = query.fetchCount();

        query.offset(pageable.getOffset());
        query.limit(pageable.getPageSize());

        return new PageImpl<>(query.fetch(), pageable, totalSize);
    }

    private JPAQuery<Tourist> getWhereQuery(String type, String keyword, JPAQuery<Tourist> query) {
        switch (type) {
            case "city":
                query = query.where(QTourist.tourist.address.city.eq(keyword));
                break;
            case "load":
                query = query.where(QTourist.tourist.address.load.eq(keyword));
                break;
            case "name":
                query = query.where(QTourist.tourist.name.eq(keyword));
                break;
            default:break;
        }
        return query;
    }
}
