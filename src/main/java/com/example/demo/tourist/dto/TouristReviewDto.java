package com.example.demo.tourist.dto;

import com.example.demo.common.model.ListResult;
import com.example.demo.tourist.entity.TouristReview;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

public class TouristReviewDto {

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class createReview{

        private String title;
        private String content;
        private Float score;
        private Long touristId;

        @Builder
        public createReview(String title, String content, Float score, Long touristId) {
            this.title = title;
            this.content = content;
            this.score = score;
            this.touristId = touristId;
        }

    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class ReviewRes{

        String title;
        String content;
        Float score;
        String user;

        public ReviewRes(TouristReview touristReview) {
            this.title = touristReview.getTitle();
            this.content = touristReview.getContent();
            this.score = touristReview.getScore();
            this.user = touristReview.getUser().getName();
        }
    }

    public static class ListResponse extends ListResult<ReviewRes>{
        public ListResponse(List<ReviewRes> content) {
            super(content);
        }
    }

}
