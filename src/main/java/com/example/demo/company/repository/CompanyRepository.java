package com.example.demo.company.repository;

import com.example.demo.company.entity.Company;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    @EntityGraph(attributePaths  ={"user","tourist"})
    @Query("select c from Company c where c.deleted = false")
    List<Company> findAllCompanies();

    @EntityGraph(attributePaths  ={"user","tourist"})
    @Query("select c from Company c where c.checkAuth = :b and c.deleted = false")
    List<Company> findByCheckAuth(boolean b);

    @EntityGraph(attributePaths  ={"user","tourist"})
    @Query("select c from Company c where c.id = :id")
    Optional<Company> findByIdForReview(Long id);

    @EntityGraph(attributePaths  ={"user","tourist"})
    @Query("select c from Company c")
    List<Company> findAllForTourist();
}
