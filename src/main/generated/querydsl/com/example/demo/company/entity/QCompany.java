package com.example.demo.company.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCompany is a Querydsl query type for Company
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCompany extends EntityPathBase<Company> {

    private static final long serialVersionUID = 1211546333L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCompany company = new QCompany("company");

    public final com.example.demo.common.model.QAddress address;

    public final BooleanPath checkAuth = createBoolean("checkAuth");

    public final ListPath<CompanyReview, QCompanyReview> companyReviewList = this.<CompanyReview, QCompanyReview>createList("companyReviewList", CompanyReview.class, QCompanyReview.class, PathInits.DIRECT2);

    public final BooleanPath deleted = createBoolean("deleted");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final com.example.demo.tourist.entity.QTourist tourist;

    public final com.example.demo.user.entity.QUser user;

    public final ListPath<UserVisitCompany, QUserVisitCompany> userVisitCompanies = this.<UserVisitCompany, QUserVisitCompany>createList("userVisitCompanies", UserVisitCompany.class, QUserVisitCompany.class, PathInits.DIRECT2);

    public QCompany(String variable) {
        this(Company.class, forVariable(variable), INITS);
    }

    public QCompany(Path<? extends Company> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCompany(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCompany(PathMetadata metadata, PathInits inits) {
        this(Company.class, metadata, inits);
    }

    public QCompany(Class<? extends Company> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.address = inits.isInitialized("address") ? new com.example.demo.common.model.QAddress(forProperty("address")) : null;
        this.tourist = inits.isInitialized("tourist") ? new com.example.demo.tourist.entity.QTourist(forProperty("tourist"), inits.get("tourist")) : null;
        this.user = inits.isInitialized("user") ? new com.example.demo.user.entity.QUser(forProperty("user"), inits.get("user")) : null;
    }

}

