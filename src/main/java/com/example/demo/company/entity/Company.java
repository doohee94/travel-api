package com.example.demo.company.entity;

import com.example.demo.common.model.Address;
import com.example.demo.company.dto.CompanyDto;
import com.example.demo.tourist.entity.Tourist;
import com.example.demo.user.dto.UserDto;
import com.example.demo.user.entity.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "COMPANY")
@SequenceGenerator(name = "COMPANY_SEQ_GEN",
        sequenceName = "COMPANY_SEQ",
        initialValue = 1,
        allocationSize = 1)
@Getter
@ToString(exclude = {"user","tourist","companyReviewList","userVisitCompanies"})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Company {

    @Id
    @Column(name = "COMPANY_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMPANY_SEQ_GEN")
    private Long id;

    private String name;
    private boolean checkAuth;

    @Embedded
    private Address address;

    private boolean deleted;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    private  User user;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "TOURIST_ID")
    private  Tourist tourist;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CompanyReview> companyReviewList;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<UserVisitCompany> userVisitCompanies;

    public Company(UserDto.CreateCompany company, User user, Tourist tourist) {
        this.name = company.getCompany().getName();
        this.checkAuth = false;
        this.address = company.getCompany().getAddress();
        this.user = user ;
        this.tourist = tourist;
        this.deleted = false;

    }

    public Company(CompanyDto.CompanyCreate company, User user, Tourist tourist) {
        this.name = company.getName();
        this.checkAuth = false;
        this.address = company.getAddress();
        this.user = user ;
        this.tourist = tourist;
        this.deleted = false;

    }

    public void allowAuth() {
        this.checkAuth = true;
    }

    public void delete() {
        this.deleted = true;
    }
}
