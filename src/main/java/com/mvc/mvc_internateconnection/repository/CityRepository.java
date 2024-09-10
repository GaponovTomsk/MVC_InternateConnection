package com.mvc.mvc_internateconnection.repository;

import com.mvc.mvc_internateconnection.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City,Long> {
    Optional<City> findCityByName(String cityName);
}
