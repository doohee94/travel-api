package com.example.demo.tourist.repository;

import com.example.demo.tourist.entity.TouristReview;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TouristReviewRepository extends JpaRepository<TouristReview, Long> {
    @EntityGraph(attributePaths = {"touristReviewComments","user"})
    @Query("select t from TouristReview t where t.id = :id")
    Optional<TouristReview> findByIdForTourist(Long id);
}
