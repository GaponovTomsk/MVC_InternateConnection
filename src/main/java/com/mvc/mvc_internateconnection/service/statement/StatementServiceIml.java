package com.mvc.mvc_internateconnection.service.statement;

import com.mvc.mvc_internateconnection.model.Statement;
import com.mvc.mvc_internateconnection.repository.StatementRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StatementServiceIml implements StatementService{

    private StatementRepository statementRepository;


    @Override
    public Statement save(Statement statement) {
        statementRepository.save(statement);
        return statement;
    }

    @Override
    public Statement read(long id) {
       Optional<Statement> statementOptional  = statementRepository.findById(id);
       return statementOptional.isPresent() ? statementOptional.get() : null;
    }

    @Override
    public Statement modify(Statement statement) {
        return statementRepository.save(statement);
    }

    @Override
    public void delete(long id) {
        statementRepository.deleteById(id);
    }

    @Override
    public List<Statement> findAll() {
        return statementRepository.findAll();
    }
}
