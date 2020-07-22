package com.example.demo.city.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserLikeCity is a Querydsl query type for UserLikeCity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUserLikeCity extends EntityPathBase<UserLikeCity> {

    private static final long serialVersionUID = -24728753L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserLikeCity userLikeCity = new QUserLikeCity("userLikeCity");

    public final QCity city;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final com.example.demo.user.entity.QUser user;

    public QUserLikeCity(String variable) {
        this(UserLikeCity.class, forVariable(variable), INITS);
    }

    public QUserLikeCity(Path<? extends UserLikeCity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserLikeCity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserLikeCity(PathMetadata metadata, PathInits inits) {
        this(UserLikeCity.class, metadata, inits);
    }

    public QUserLikeCity(Class<? extends UserLikeCity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.city = inits.isInitialized("city") ? new QCity(forProperty("city"), inits.get("city")) : null;
        this.user = inits.isInitialized("user") ? new com.example.demo.user.entity.QUser(forProperty("user"), inits.get("user")) : null;
    }

}

