package com.example.demo.company.dto;

import com.example.demo.common.model.ListResult;
import com.example.demo.company.entity.CompanyReviewComment;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

public class CompanyCommentDto {
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class CreateComment{

        String comment;
        Long reviewId;

        public CreateComment(String comment, Long reviewId) {
            this.comment = comment;
            this.reviewId = reviewId;
        }
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class CommentRes{

        String user;
        String comment;

        @Builder
        public CommentRes(CompanyReviewComment companyReviewComment) {
            this.user = companyReviewComment.getUser().getName();
            this.comment = companyReviewComment.getContent();
        }
    }

    public static class ListResponse extends ListResult<CompanyCommentDto.CommentRes> {
        public ListResponse(List<CompanyCommentDto.CommentRes> content) {
            super(content);
        }
    }
}
