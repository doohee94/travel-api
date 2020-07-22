package com.example.demo.tourist.entity;

import com.example.demo.tourist.dto.TouristReviewDto;
import com.example.demo.user.entity.User;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TOURIST_REVIEW")
@SequenceGenerator(name = "TOURIST_REVIEW_SEQ_GEN",
        sequenceName = "TOURIST_REVIEW_SEQ",
        initialValue = 1,
        allocationSize = 1)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(exclude = {"user","touristReviewComments","tourist"})
public class TouristReview {
    @Id
    @Column(name = "TOURIST_REVIEW_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TOURIST_REVIEW_SEQ_GEN")
    private  Long id;

    private String title;
    private String content;
    private Float score;
    private Boolean deleted;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "TOURIST_ID")
    private Tourist tourist;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

    @OneToMany(mappedBy = "touristReview", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TouristReviewComment> touristReviewComments;

    @Builder
    public TouristReview(TouristReviewDto.createReview createReview, User user, Tourist tourist) {
        this.title = createReview.getTitle();
        this.content = createReview.getContent();
        this.score = createReview.getScore();
        this.deleted = false;
        this.tourist = tourist;
        this.user = user;
    }
}
