package com.example.demo.user.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = 305253613L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUser user = new QUser("user");

    public final com.example.demo.common.model.QAddress address;

    public final ListPath<com.example.demo.company.entity.Company, com.example.demo.company.entity.QCompany> companies = this.<com.example.demo.company.entity.Company, com.example.demo.company.entity.QCompany>createList("companies", com.example.demo.company.entity.Company.class, com.example.demo.company.entity.QCompany.class, PathInits.DIRECT2);

    public final ListPath<com.example.demo.company.entity.CompanyReview, com.example.demo.company.entity.QCompanyReview> companyReviews = this.<com.example.demo.company.entity.CompanyReview, com.example.demo.company.entity.QCompanyReview>createList("companyReviews", com.example.demo.company.entity.CompanyReview.class, com.example.demo.company.entity.QCompanyReview.class, PathInits.DIRECT2);

    public final StringPath email = createString("email");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final StringPath password = createString("password");

    public final QRole role;

    public final ListPath<com.example.demo.tourist.entity.TouristReview, com.example.demo.tourist.entity.QTouristReview> touristReviews = this.<com.example.demo.tourist.entity.TouristReview, com.example.demo.tourist.entity.QTouristReview>createList("touristReviews", com.example.demo.tourist.entity.TouristReview.class, com.example.demo.tourist.entity.QTouristReview.class, PathInits.DIRECT2);

    public final ListPath<com.example.demo.city.entity.UserLikeCity, com.example.demo.city.entity.QUserLikeCity> userLikeCities = this.<com.example.demo.city.entity.UserLikeCity, com.example.demo.city.entity.QUserLikeCity>createList("userLikeCities", com.example.demo.city.entity.UserLikeCity.class, com.example.demo.city.entity.QUserLikeCity.class, PathInits.DIRECT2);

    public final ListPath<com.example.demo.company.entity.UserVisitCompany, com.example.demo.company.entity.QUserVisitCompany> userVisitCompanies = this.<com.example.demo.company.entity.UserVisitCompany, com.example.demo.company.entity.QUserVisitCompany>createList("userVisitCompanies", com.example.demo.company.entity.UserVisitCompany.class, com.example.demo.company.entity.QUserVisitCompany.class, PathInits.DIRECT2);

    public QUser(String variable) {
        this(User.class, forVariable(variable), INITS);
    }

    public QUser(Path<? extends User> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUser(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUser(PathMetadata metadata, PathInits inits) {
        this(User.class, metadata, inits);
    }

    public QUser(Class<? extends User> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.address = inits.isInitialized("address") ? new com.example.demo.common.model.QAddress(forProperty("address")) : null;
        this.role = inits.isInitialized("role") ? new QRole(forProperty("role")) : null;
    }

}

