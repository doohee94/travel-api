package com.example.demo.tourist.repository;

import com.example.demo.tourist.entity.Tourist;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TouristRepositoryCustom {

    Page<Tourist> findByType(String type, String keyword, Pageable pageable);

}
