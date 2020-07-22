package com.example.demo.city.repository;

import com.example.demo.city.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CityRepository extends JpaRepository<City, Long> {
    Optional<City> findByAddress_City(String city);
}
