package com.example.demo.company.repository;

import com.example.demo.company.entity.CompanyReviewComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyReviewCommentRepository extends JpaRepository<CompanyReviewComment, Long> {
}
