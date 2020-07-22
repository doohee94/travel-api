package com.example.demo.company.entity;

import com.example.demo.company.dto.CompanyCommentDto;
import com.example.demo.user.entity.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "COMPANY_REVIEW_COMMENT")
@SequenceGenerator(name = "COMPANY_REVIEW_COMMENT_SEQ_GEN",
        sequenceName = "COMPANY_REVIEW_COMMENT_SEQ",
        initialValue = 1,
        allocationSize = 1)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CompanyReviewComment {
    @Id
    @Column(name = "COMPANY_REVIEW_COMMENT_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMPANY_REVIEW_COMMENT_SEQ_GEN")
    private Long id;

    private String content;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "COMPANY_REVIEW_ID")
    private CompanyReview companyReview;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

    @Builder
    public CompanyReviewComment(CompanyCommentDto.CreateComment createComment, CompanyReview companyReview, User user) {
        this.content = createComment.getComment();
        this.companyReview = companyReview;
        this.user = user;
    }
}
