package com.example.demo.company.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCompanyReview is a Querydsl query type for CompanyReview
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCompanyReview extends EntityPathBase<CompanyReview> {

    private static final long serialVersionUID = 1261978773L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCompanyReview companyReview = new QCompanyReview("companyReview");

    public final QCompany company;

    public final ListPath<CompanyReviewComment, QCompanyReviewComment> companyReviewComments = this.<CompanyReviewComment, QCompanyReviewComment>createList("companyReviewComments", CompanyReviewComment.class, QCompanyReviewComment.class, PathInits.DIRECT2);

    public final StringPath content = createString("content");

    public final BooleanPath deleted = createBoolean("deleted");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Float> score = createNumber("score", Float.class);

    public final StringPath title = createString("title");

    public final com.example.demo.user.entity.QUser user;

    public QCompanyReview(String variable) {
        this(CompanyReview.class, forVariable(variable), INITS);
    }

    public QCompanyReview(Path<? extends CompanyReview> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCompanyReview(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCompanyReview(PathMetadata metadata, PathInits inits) {
        this(CompanyReview.class, metadata, inits);
    }

    public QCompanyReview(Class<? extends CompanyReview> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.company = inits.isInitialized("company") ? new QCompany(forProperty("company"), inits.get("company")) : null;
        this.user = inits.isInitialized("user") ? new com.example.demo.user.entity.QUser(forProperty("user"), inits.get("user")) : null;
    }

}

