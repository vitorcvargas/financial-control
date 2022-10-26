package com.financialctl.financialinfo.infrastructure.adapters.output.persistence.mappers;

import com.financialctl.financialinfo.domain.models.Operation;
import com.financialctl.financialinfo.infrastructure.adapters.output.persistence.entities.OperationDB;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(uses = FinanceDBMapper.class)
public interface OperationDBMapper {

    OperationDBMapper INSTANCE = Mappers.getMapper(OperationDBMapper.class);

    @Mappings({
            @Mapping(target = "finance.operations", ignore = true)
    })
    OperationDB operationToOperationDB(final Operation operation);

    @Mappings({
            @Mapping(target = "finance.operations", ignore = true)
    })
    Operation operationDBToOperation(final OperationDB operationDB);
}
