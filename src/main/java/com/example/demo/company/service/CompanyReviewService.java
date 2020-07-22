package com.example.demo.company.service;

import com.example.demo.company.dto.CompanyReviewDto;
import com.example.demo.company.entity.Company;
import com.example.demo.company.dto.CompanyCommentDto;
import com.example.demo.company.entity.CompanyReview;
import com.example.demo.company.entity.CompanyReviewComment;
import com.example.demo.company.repository.CompanyRepository;
import com.example.demo.company.repository.CompanyReviewCommentRepository;
import com.example.demo.company.repository.CompanyReviewRepository;
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
public class CompanyReviewService {

    private final CompanyReviewRepository companyReviewRepository;
    private final CompanyReviewCommentRepository companyReviewCommentRepository;
    private final UserRepository userRepository;
    private final CompanyRepository companyRepository;

    public void createReview(CompanyReviewDto.createReview createReview) {
        //TODO: user 로그인 한 사람으로 가져오기 일단은2번

        User user = userRepository.findById(2L).orElseThrow(NullPointerException::new);
        Company company = companyRepository.findById(createReview.getCompanyId()).orElseThrow(NullPointerException::new);

        companyReviewRepository.save(CompanyReview.builder()
                .createReview(createReview)
                .company(company)
                .user(user)
                .build());

    }

    public void createComment(CompanyCommentDto.CreateComment createComment) {
        //TODO: user 로그인 한 사람으로 가져오기 일단은2번

        User user = userRepository.findById(2L).orElseThrow(NullPointerException::new);
        CompanyReview companyReview = companyReviewRepository.findById(createComment.getReviewId()).orElseThrow(NullPointerException::new);

        companyReviewCommentRepository.save(CompanyReviewComment.builder()
                .createComment(createComment)
                .user(user)
                .companyReview(companyReview)
                .build());
    }

    public List<CompanyReviewDto.ReviewRes> getReviews(Long id) {
        return companyRepository.findByIdForReview(id).orElseThrow(NullPointerException::new)
                .getCompanyReviewList().stream()
                .map(CompanyReviewDto.ReviewRes::new)
                .collect(Collectors.toList());
    }

    public List<CompanyCommentDto.CommentRes> getComment(Long id) {
        return companyReviewRepository.findByIdForReview(id).orElseThrow(NullPointerException::new)
                .getCompanyReviewComments().stream().map(CompanyCommentDto.CommentRes::new)
                .collect(Collectors.toList());
    }


}
