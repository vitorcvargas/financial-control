package com.financialctl.financialinfo.infrastructure.adapters.output.persistence.mappers;

import com.financialctl.financialinfo.domain.models.Finance;
import com.financialctl.financialinfo.infrastructure.adapters.output.persistence.entities.FinanceDB;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FinanceDBMapper {

    FinanceDBMapper INSTANCE = Mappers.getMapper(FinanceDBMapper.class);

    FinanceDB financeToFinanceDB(final Finance finance, @Context CycleAvoidingMappingContext context);

    Finance financeDBToFinance(final FinanceDB financeDB, @Context CycleAvoidingMappingContext context);
}
