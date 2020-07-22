package com.example.demo.company.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserVisitCompany is a Querydsl query type for UserVisitCompany
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUserVisitCompany extends EntityPathBase<UserVisitCompany> {

    private static final long serialVersionUID = 1829740989L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserVisitCompany userVisitCompany = new QUserVisitCompany("userVisitCompany");

    public final QCompany company;

    public final DateTimePath<java.time.LocalDateTime> dataTime = createDateTime("dataTime", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final com.example.demo.user.entity.QUser user;

    public QUserVisitCompany(String variable) {
        this(UserVisitCompany.class, forVariable(variable), INITS);
    }

    public QUserVisitCompany(Path<? extends UserVisitCompany> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserVisitCompany(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserVisitCompany(PathMetadata metadata, PathInits inits) {
        this(UserVisitCompany.class, metadata, inits);
    }

    public QUserVisitCompany(Class<? extends UserVisitCompany> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.company = inits.isInitialized("company") ? new QCompany(forProperty("company"), inits.get("company")) : null;
        this.user = inits.isInitialized("user") ? new com.example.demo.user.entity.QUser(forProperty("user"), inits.get("user")) : null;
    }

}

