package com.financialctl.financialinfo.infrastructure.adapters.output.persistence.mappers;

import com.financialctl.financialinfo.domain.models.Income;
import com.financialctl.financialinfo.infrastructure.adapters.output.persistence.entity.IncomeDB;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IncomeDBMapper {
    IncomeDBMapper INSTANCE = Mappers.getMapper(IncomeDBMapper.class);

    IncomeDB incomeToIncomeDB(final Income income);

    Income incomeDBToIncome(final IncomeDB incomeDB);
}
