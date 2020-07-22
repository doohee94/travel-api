package com.example.demo.tourist.dto;

import com.example.demo.common.model.ListResult;
import com.example.demo.tourist.entity.TouristReview;
import com.example.demo.tourist.entity.TouristReviewComment;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

public class TouristCommentDto {

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
        public CommentRes(TouristReviewComment touristReviewComment) {
            this.user = touristReviewComment.getUser().getName();
            this.comment = touristReviewComment.getContent();
        }
    }

    public static class ListResponse extends ListResult<CommentRes> {
        public ListResponse(List<CommentRes> content) {
            super(content);
        }
    }

}
