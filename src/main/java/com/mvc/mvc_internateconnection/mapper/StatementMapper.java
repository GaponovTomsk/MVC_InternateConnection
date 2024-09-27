package com.mvc.mvc_internateconnection.mapper;

import com.mvc.mvc_internateconnection.model.Statement;
import com.mvc.mvc_internateconnection.model.dto.StatementDTO;
import org.mapstruct.Mapper;

@Mapper
public interface StatementMapper {

    Statement toEntity(StatementDTO statementDTO);
    StatementDTO toDto (Statement statement);
}
