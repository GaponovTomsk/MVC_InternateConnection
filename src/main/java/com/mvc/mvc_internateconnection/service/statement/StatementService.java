package com.mvc.mvc_internateconnection.service.statement;

import com.mvc.mvc_internateconnection.model.Statement;

public interface StatementService {
    Statement save(Statement statement);
    Statement read(long id);
    Statement modify(Statement statement);
    void delete(long id);
}
