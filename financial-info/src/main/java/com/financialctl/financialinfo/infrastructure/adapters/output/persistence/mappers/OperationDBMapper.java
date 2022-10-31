package com.financialctl.financialinfo.infrastructure.adapters.output.persistence.mappers;

import com.financialctl.financialinfo.domain.models.Operation;
import com.financialctl.financialinfo.infrastructure.adapters.output.persistence.entities.OperationDB;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OperationDBMapper {

    OperationDBMapper INSTANCE = Mappers.getMapper(OperationDBMapper.class);

    OperationDB operationToOperationDB(final Operation operation, @Context CycleAvoidingMappingContext context);

    Operation operationDBToOperation(final OperationDB operationDB, @Context CycleAvoidingMappingContext context);
}
