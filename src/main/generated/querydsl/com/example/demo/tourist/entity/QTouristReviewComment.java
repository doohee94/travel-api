package com.example.demo.tourist.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTouristReviewComment is a Querydsl query type for TouristReviewComment
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTouristReviewComment extends EntityPathBase<TouristReviewComment> {

    private static final long serialVersionUID = 1130314922L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTouristReviewComment touristReviewComment = new QTouristReviewComment("touristReviewComment");

    public final StringPath content = createString("content");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QTouristReview touristReview;

    public final com.example.demo.user.entity.QUser user;

    public QTouristReviewComment(String variable) {
        this(TouristReviewComment.class, forVariable(variable), INITS);
    }

    public QTouristReviewComment(Path<? extends TouristReviewComment> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTouristReviewComment(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTouristReviewComment(PathMetadata metadata, PathInits inits) {
        this(TouristReviewComment.class, metadata, inits);
    }

    public QTouristReviewComment(Class<? extends TouristReviewComment> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.touristReview = inits.isInitialized("touristReview") ? new QTouristReview(forProperty("touristReview"), inits.get("touristReview")) : null;
        this.user = inits.isInitialized("user") ? new com.example.demo.user.entity.QUser(forProperty("user"), inits.get("user")) : null;
    }

}

