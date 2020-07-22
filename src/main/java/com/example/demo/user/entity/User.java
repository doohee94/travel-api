package com.example.demo.user.entity;

import com.example.demo.city.entity.UserLikeCity;
import com.example.demo.common.model.Address;
import com.example.demo.company.entity.Company;
import com.example.demo.company.entity.CompanyReview;
import com.example.demo.company.entity.UserVisitCompany;
import com.example.demo.tourist.entity.TouristReview;
import com.example.demo.user.dto.UserDto;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SequenceGenerator(name = "USER_SEQ_GEN",
        sequenceName = "USER_SEQ",
        initialValue = 1,
        allocationSize = 1)
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "USER_SEQ_GEN")
    private Long id;

    private String name;
    private String email;
    private String password;

    @Embedded
    private Address address;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "ROLE_ID")
    private  Role role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private  List<Company> companies;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<UserLikeCity> userLikeCities;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private  List<CompanyReview> companyReviews;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private  List<TouristReview> touristReviews;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<UserVisitCompany> userVisitCompanies;


    public User(UserDto.CreateMemberUser userDto, Role role) {
        this.name = userDto.getName();
        this.email = userDto.getEmail();
        this.password = userDto.getPassword();
        this.address = userDto.getAddress();
        this.role = role;
    }

    public User(UserDto.CreateCompany company, Role role) {
        this.name = company.getName();
        this.email = company.getEmail();
        this.password = company.getPassword();
        this.address = company.getAddress();
        this.role = role;
    }
}
