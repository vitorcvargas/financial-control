package com.financialctl.financialinfo.infrastructure.adapters.input.rest.mappers;

import com.financialctl.financialinfo.domain.models.OperationFilter;
import com.financialctl.financialinfo.infrastructure.adapters.input.rest.dtos.finance.OperationFilterDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = DateMapper.class)
public interface OperationFilterMapper {

    OperationFilterMapper INSTANCE = Mappers.getMapper(OperationFilterMapper.class);

    OperationFilter operationFilterDTOToOperationFilter(final Long financeId, final OperationFilterDTO filter);
}
