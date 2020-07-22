package com.example.demo.company.entity;

import com.example.demo.company.dto.CompanyReviewDto;
import com.example.demo.user.entity.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "COMPANY_REVIEW")
@SequenceGenerator(name = "COMPANY_REVIEW_SEQ_GEN",
        sequenceName = "COMPANY_REVIEW_SEQ",
        initialValue = 1,
        allocationSize = 1)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CompanyReview {

    @Id
    @Column(name = "COMPANY_REVIEW_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMPANY_REVIEW_SEQ_GEN")
    private Long id;
    private String title;
    private String content;
    private Float score;
    private Boolean deleted;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "COMPANY_ID")
    private Company company;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

    @OneToMany(mappedBy = "companyReview", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CompanyReviewComment> companyReviewComments;

    @Builder
    public CompanyReview(CompanyReviewDto.createReview createReview, User user, Company company) {
        this.title =  createReview.getTitle();
        this.content =  createReview.getContent();
        this.score =  createReview.getScore();
        this.deleted =  false;
        this.company = company;
        this.user = user;
    }
}
