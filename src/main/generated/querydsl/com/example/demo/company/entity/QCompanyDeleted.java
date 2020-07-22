package com.example.demo.company.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCompanyDeleted is a Querydsl query type for CompanyDeleted
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCompanyDeleted extends EntityPathBase<CompanyDeleted> {

    private static final long serialVersionUID = 917146236L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCompanyDeleted companyDeleted = new QCompanyDeleted("companyDeleted");

    public final BooleanPath allow = createBoolean("allow");

    public final QCompany company;

    public final DateTimePath<java.time.LocalDateTime> deletedDate = createDateTime("deletedDate", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final EnumPath<Reason> reason = createEnum("reason", Reason.class);

    public final StringPath reasonDetail = createString("reasonDetail");

    public QCompanyDeleted(String variable) {
        this(CompanyDeleted.class, forVariable(variable), INITS);
    }

    public QCompanyDeleted(Path<? extends CompanyDeleted> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCompanyDeleted(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCompanyDeleted(PathMetadata metadata, PathInits inits) {
        this(CompanyDeleted.class, metadata, inits);
    }

    public QCompanyDeleted(Class<? extends CompanyDeleted> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.company = inits.isInitialized("company") ? new QCompany(forProperty("company"), inits.get("company")) : null;
    }

}

