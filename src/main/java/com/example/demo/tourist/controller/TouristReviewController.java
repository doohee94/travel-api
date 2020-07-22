package com.example.demo.tourist.controller;

import com.example.demo.tourist.dto.TouristCommentDto;
import com.example.demo.tourist.dto.TouristReviewDto;
import com.example.demo.tourist.service.TouristReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/travel/tourist/review")
@RequiredArgsConstructor
public class TouristReviewController {

    private final TouristReviewService touristReviewService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createReview(@RequestBody TouristReviewDto.createReview createReview){
        touristReviewService.createReview(createReview);
    }

    @PostMapping(value = "/comment")
    @ResponseStatus(HttpStatus.CREATED)
    public void createComment(TouristCommentDto.CreateComment createComment){
        touristReviewService.createComment(createComment);
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TouristReviewDto.ListResponse getReviews(@PathVariable Long id){
        return new TouristReviewDto.ListResponse(touristReviewService.getReviews(id));
    }

    @GetMapping(value = "/comment/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TouristCommentDto.ListResponse getComments(@PathVariable Long id){
        return new TouristCommentDto.ListResponse(touristReviewService.getComment(id));
    }

}
