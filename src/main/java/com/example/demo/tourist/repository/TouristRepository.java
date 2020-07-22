package com.example.demo.tourist.repository;

import com.example.demo.tourist.entity.Tourist;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TouristRepository extends JpaRepository<Tourist, Long>,TouristRepositoryCustom {

    Tourist findByCity(String tourist);

    @EntityGraph(attributePaths = {"touristReviews","city"})
    @Query("select t from Tourist t where t.id = :id")
    Optional<Tourist> findByIdForTourist(Long id);

    @EntityGraph(attributePaths = {"touristReviews","city"})
    @Query("select t from Tourist t")
    List<Tourist> findAllForTourist();

}
