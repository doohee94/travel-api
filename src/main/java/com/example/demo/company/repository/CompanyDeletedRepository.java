package com.example.demo.company.repository;

import com.example.demo.company.entity.CompanyDeleted;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CompanyDeletedRepository extends JpaRepository<CompanyDeleted, Long> {

    @EntityGraph(attributePaths = {"company"})
    @Query("select c from CompanyDeleted c where c.allow= :b")
    List<CompanyDeleted> findAllByAllow(boolean b);

    @EntityGraph(attributePaths = {"company"})
    @Query("select c from CompanyDeleted  c where c.id = :id")
    Optional<CompanyDeleted> findByIdForDelete(Long id);
}
