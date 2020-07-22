package com.example.demo.company.controller;

import com.example.demo.company.dto.CompanyReviewDto;
import com.example.demo.company.service.CompanyReviewService;
import com.example.demo.company.dto.CompanyCommentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/company/review")
@RequiredArgsConstructor
public class CompanyReviewController {

    private final CompanyReviewService companyReviewService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createReview(@RequestBody CompanyReviewDto.createReview createReview){
        companyReviewService.createReview(createReview);
    }

    @PostMapping(value = "/comment")
    @ResponseStatus(HttpStatus.CREATED)
    public void createComment(CompanyCommentDto.CreateComment createComment){
        companyReviewService.createComment(createComment);
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CompanyReviewDto.ListResponse getReviews(@PathVariable Long id){
        return new CompanyReviewDto.ListResponse(companyReviewService.getReviews(id));
    }

    @GetMapping(value = "/comment/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CompanyCommentDto.ListResponse getComments(@PathVariable Long id){
        return new CompanyCommentDto.ListResponse(companyReviewService.getComment(id));
    }

}
