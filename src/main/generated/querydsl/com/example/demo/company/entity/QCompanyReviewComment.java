package com.example.demo.company.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCompanyReviewComment is a Querydsl query type for CompanyReviewComment
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCompanyReviewComment extends EntityPathBase<CompanyReviewComment> {

    private static final long serialVersionUID = 127983626L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCompanyReviewComment companyReviewComment = new QCompanyReviewComment("companyReviewComment");

    public final QCompanyReview companyReview;

    public final StringPath content = createString("content");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final com.example.demo.user.entity.QUser user;

    public QCompanyReviewComment(String variable) {
        this(CompanyReviewComment.class, forVariable(variable), INITS);
    }

    public QCompanyReviewComment(Path<? extends CompanyReviewComment> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCompanyReviewComment(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCompanyReviewComment(PathMetadata metadata, PathInits inits) {
        this(CompanyReviewComment.class, metadata, inits);
    }

    public QCompanyReviewComment(Class<? extends CompanyReviewComment> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.companyReview = inits.isInitialized("companyReview") ? new QCompanyReview(forProperty("companyReview"), inits.get("companyReview")) : null;
        this.user = inits.isInitialized("user") ? new com.example.demo.user.entity.QUser(forProperty("user"), inits.get("user")) : null;
    }

}

