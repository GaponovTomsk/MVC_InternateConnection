package com.mvc.mvc_internateconnection.repository;

import com.mvc.mvc_internateconnection.model.Statement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StatementRepository extends CrudRepository<Statement,Long> {


}
