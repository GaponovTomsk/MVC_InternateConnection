package com.mvc.mvc_internateconnection.repository;


import com.mvc.mvc_internateconnection.model.Street;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StreetRepository extends JpaRepository<Street,Long> {

}
