package com.example.demo.tourist.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTourist is a Querydsl query type for Tourist
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTourist extends EntityPathBase<Tourist> {

    private static final long serialVersionUID = -482452931L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTourist tourist = new QTourist("tourist");

    public final com.example.demo.common.model.QAddress address;

    public final com.example.demo.city.entity.QCity city;

    public final BooleanPath deleted = createBoolean("deleted");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final ListPath<TouristReview, QTouristReview> touristReviews = this.<TouristReview, QTouristReview>createList("touristReviews", TouristReview.class, QTouristReview.class, PathInits.DIRECT2);

    public QTourist(String variable) {
        this(Tourist.class, forVariable(variable), INITS);
    }

    public QTourist(Path<? extends Tourist> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTourist(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTourist(PathMetadata metadata, PathInits inits) {
        this(Tourist.class, metadata, inits);
    }

    public QTourist(Class<? extends Tourist> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.address = inits.isInitialized("address") ? new com.example.demo.common.model.QAddress(forProperty("address")) : null;
        this.city = inits.isInitialized("city") ? new com.example.demo.city.entity.QCity(forProperty("city"), inits.get("city")) : null;
    }

}

