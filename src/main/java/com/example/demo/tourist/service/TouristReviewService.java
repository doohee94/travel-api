package com.example.demo.tourist.service;

import com.example.demo.tourist.dto.TouristCommentDto;
import com.example.demo.tourist.dto.TouristReviewDto;
import com.example.demo.tourist.entity.Tourist;
import com.example.demo.tourist.entity.TouristReview;
import com.example.demo.tourist.entity.TouristReviewComment;
import com.example.demo.tourist.repository.TouristCommentRepository;
import com.example.demo.tourist.repository.TouristRepository;
import com.example.demo.tourist.repository.TouristReviewRepository;
import com.example.demo.user.entity.User;
import com.example.demo.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class TouristReviewService {

    private final TouristReviewRepository touristReviewRepository;
    private final UserRepository userRepository;
    private final TouristRepository touristRepository;
    private final TouristCommentRepository touristCommentRepository;


    public void createReview(TouristReviewDto.createReview createReview) {

        //TODO: user 로그인 한 사람으로 가져오기 일단은2번

        User user = userRepository.findById(2L).orElseThrow(NullPointerException::new);
        Tourist tourist = touristRepository.findById(createReview.getTouristId()).orElseThrow(NullPointerException::new);

        touristReviewRepository.save(TouristReview.builder()
                .createReview(createReview)
                .tourist(tourist)
                .user(user)
                .build());

    }


    public void createComment(TouristCommentDto.CreateComment createComment) {
        //TODO: user 로그인 한 사람으로 가져오기 일단은2번

        User user = userRepository.findById(2L).orElseThrow(NullPointerException::new);
        TouristReview touristReview = touristReviewRepository.findById(createComment.getReviewId()).orElseThrow(NullPointerException::new);

        touristCommentRepository.save(TouristReviewComment.builder()
                .createComment(createComment)
                .user(user)
                .review(touristReview)
                .build());

    }

    public List<TouristReviewDto.ReviewRes> getReviews(Long id) {

        return touristRepository.findByIdForTourist(id).orElseThrow(NullPointerException::new)
                .getTouristReviews().stream()
                .map(TouristReviewDto.ReviewRes::new)
                .collect(Collectors.toList());
    }

    public List<TouristCommentDto.CommentRes> getComment(Long id) {
        return touristReviewRepository.findByIdForTourist(id).orElseThrow(NullPointerException::new)
                .getTouristReviewComments().stream().map(TouristCommentDto.CommentRes::new)
                .collect(Collectors.toList());
    }
}
