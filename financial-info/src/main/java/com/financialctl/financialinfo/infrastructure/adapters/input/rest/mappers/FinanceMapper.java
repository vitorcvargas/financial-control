package com.financialctl.financialinfo.infrastructure.adapters.input.rest.mappers;

import com.financialctl.financialinfo.domain.models.OperationFilter;
import com.financialctl.financialinfo.domain.models.enums.OperationEntry;
import com.financialctl.financialinfo.infrastructure.adapters.input.rest.dtos.finance.OperationFilterDTO;
import com.financialctl.financialinfo.infrastructure.adapters.output.persistence.entities.enums.OperationEntryDB;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.HashMap;
import java.util.Map;

@Mapper(uses = DateMapper.class)
public interface FinanceMapper {

    FinanceMapper INSTANCE = Mappers.getMapper(FinanceMapper.class);

    OperationFilter operationFilterDTOToOperationFilter(final Long financeId, final OperationFilterDTO filter);

    HashMap<OperationEntry, Double> budgetDTOToBudget(final Map<OperationEntryDB, Double> budgetDTO);

    Map<OperationEntryDB, Double> budgetToBudgetDTO(final Map<OperationEntry, Double> budget);
}
