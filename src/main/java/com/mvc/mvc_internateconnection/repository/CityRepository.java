package com.mvc.mvc_internateconnection.repository;

import com.mvc.mvc_internateconnection.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City,Long> {
    @Query(value = "select c from City c JOIN FETCH c.streets where c.name = :city")
    Optional<City> findCityByNameWithStreets(@Param("city") String cityName);
}

