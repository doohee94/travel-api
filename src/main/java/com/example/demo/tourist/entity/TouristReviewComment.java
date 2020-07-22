package com.example.demo.tourist.entity;

import com.example.demo.tourist.dto.TouristCommentDto;
import com.example.demo.user.entity.User;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "TOURIST_REVIEW_COMMENT")
@SequenceGenerator(name = "TOURIST_REVIEW_COMMENT_SEQ_GEN",
        sequenceName = "TOURIST_REVIEW_COMMENT_SEQ",
        initialValue = 1,
        allocationSize = 1)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(exclude = {"user","touristReview"})
public class TouristReviewComment {
    @Id
    @Column(name = "TOURIST_REVIEW_COMMENT_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TOURIST_REVIEW_COMMENT_SEQ_GEN")
    private Long id;
    private String content;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "TOURIST_REVIEW_ID")
    private TouristReview touristReview;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

    @Builder
    public TouristReviewComment(TouristCommentDto.CreateComment createComment, User user, TouristReview review) {
        this.content = createComment.getComment();
        this.touristReview = review;
        this.user = user;
    }
}
