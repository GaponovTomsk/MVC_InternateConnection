package com.mvc.mvc_internateconnection.repository;

import com.mvc.mvc_internateconnection.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City,Long> {

}
