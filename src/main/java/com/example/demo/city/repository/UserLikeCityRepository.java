package com.example.demo.city.repository;

import com.example.demo.city.entity.UserLikeCity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLikeCityRepository extends JpaRepository<UserLikeCity, Long> {
}
