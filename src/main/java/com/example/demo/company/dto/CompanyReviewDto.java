package com.example.demo.company.dto;

import com.example.demo.common.model.ListResult;
import com.example.demo.company.entity.CompanyReview;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

public class CompanyReviewDto {

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class createReview{

        private String title;
        private String content;
        private Float score;
        private Long companyId;

        @Builder
        public createReview(String title, String content, Float score, Long companyId) {
            this.title = title;
            this.content = content;
            this.score = score;
            this.companyId = companyId;
        }

    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class ReviewRes{

        String title;
        String content;
        Float score;
        String user;

        public ReviewRes(CompanyReview companyReview) {
            this.title = companyReview.getTitle();
            this.content = companyReview.getContent();
            this.score = companyReview.getScore();
            this.user = companyReview.getUser().getName();
        }
    }

    public static class ListResponse extends ListResult<CompanyReviewDto.ReviewRes> {
        public ListResponse(List<CompanyReviewDto.ReviewRes> content) {
            super(content);
        }
    }

}
