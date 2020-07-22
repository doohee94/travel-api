package com.example.demo.tourist.repository;

import com.example.demo.tourist.entity.TouristReviewComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TouristCommentRepository extends JpaRepository<TouristReviewComment, Long> {

}
