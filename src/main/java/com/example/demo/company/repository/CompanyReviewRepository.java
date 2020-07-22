package com.example.demo.company.repository;

import com.example.demo.company.entity.CompanyReview;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CompanyReviewRepository extends JpaRepository<CompanyReview, Long> {

    @EntityGraph(attributePaths = {"companyReviewComments","user","company"})
    @Query("select c from CompanyReview c where c.id = :id")
    Optional<CompanyReview> findByIdForReview(Long id);

}
