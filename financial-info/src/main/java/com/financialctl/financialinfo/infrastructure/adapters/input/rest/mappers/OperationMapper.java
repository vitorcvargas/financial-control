package com.financialctl.financialinfo.infrastructure.adapters.input.rest.mappers;

import com.financialctl.financialinfo.domain.models.Finance;
import com.financialctl.financialinfo.domain.models.Operation;
import com.financialctl.financialinfo.domain.models.enums.OperationEntry;
import com.financialctl.financialinfo.infrastructure.adapters.input.rest.dtos.operation.OperationRequestDTO;
import com.financialctl.financialinfo.infrastructure.adapters.input.rest.dtos.operation.OperationResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OperationMapper {

    OperationMapper INSTANCE = Mappers.getMapper(OperationMapper.class);

    default Operation operationRequestDTOToOperation(final OperationRequestDTO request) {
        final Operation operation = new Operation();
        final Finance finance = new Finance();
        finance.setId(request.getFinanceId());
        operation.setOperationEntry(OperationEntry.fromId(request.getOperationEntry()));
        operation.setAmount(request.getAmount());
        operation.setDate(request.getDate());
        operation.setDescription(request.getDescription());
        operation.setFinance(finance);

        return operation;
    }

    OperationResponseDTO operationToOperationResponseDTO(final Operation operation);
}
