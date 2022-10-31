package com.financialctl.financialinfo.infrastructure.adapters.input.rest.mappers;

import com.financialctl.financialinfo.domain.models.Operation;
import com.financialctl.financialinfo.infrastructure.adapters.input.rest.dtos.operation.OperationRequestDTO;
import com.financialctl.financialinfo.infrastructure.adapters.input.rest.dtos.operation.OperationResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = DateMapper.class)
public interface OperationMapper {

    OperationMapper INSTANCE = Mappers.getMapper(OperationMapper.class);

    Operation operationRequestDTOToOperation(final OperationRequestDTO request);

    Operation operationRequestDTOToOperation(final OperationRequestDTO request, final Long id);

    @Mapping(target = "financeId", source = "finance.id")
    OperationResponseDTO operationToOperationResponseDTO(final Operation operation);

    List<OperationResponseDTO> operationsToOperationResponsesDTO(final List<Operation> operations);
}
