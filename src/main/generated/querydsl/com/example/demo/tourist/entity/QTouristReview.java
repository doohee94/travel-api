package com.example.demo.tourist.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTouristReview is a Querydsl query type for TouristReview
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTouristReview extends EntityPathBase<TouristReview> {

    private static final long serialVersionUID = 438492149L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTouristReview touristReview = new QTouristReview("touristReview");

    public final StringPath content = createString("content");

    public final BooleanPath deleted = createBoolean("deleted");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Float> score = createNumber("score", Float.class);

    public final StringPath title = createString("title");

    public final QTourist tourist;

    public final ListPath<TouristReviewComment, QTouristReviewComment> touristReviewComments = this.<TouristReviewComment, QTouristReviewComment>createList("touristReviewComments", TouristReviewComment.class, QTouristReviewComment.class, PathInits.DIRECT2);

    public final com.example.demo.user.entity.QUser user;

    public QTouristReview(String variable) {
        this(TouristReview.class, forVariable(variable), INITS);
    }

    public QTouristReview(Path<? extends TouristReview> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTouristReview(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTouristReview(PathMetadata metadata, PathInits inits) {
        this(TouristReview.class, metadata, inits);
    }

    public QTouristReview(Class<? extends TouristReview> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.tourist = inits.isInitialized("tourist") ? new QTourist(forProperty("tourist"), inits.get("tourist")) : null;
        this.user = inits.isInitialized("user") ? new com.example.demo.user.entity.QUser(forProperty("user"), inits.get("user")) : null;
    }

}

