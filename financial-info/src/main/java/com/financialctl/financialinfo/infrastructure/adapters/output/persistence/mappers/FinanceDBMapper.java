package com.financialctl.financialinfo.infrastructure.adapters.output.persistence.mappers;

import com.financialctl.financialinfo.domain.models.Finance;
import com.financialctl.financialinfo.infrastructure.adapters.output.persistence.entities.FinanceDB;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FinanceDBMapper {

    FinanceDBMapper INSTANCE = Mappers.getMapper(FinanceDBMapper.class);

    @Mappings({
            @Mapping(target = "user.finance", ignore = true),
            @Mapping(target = "operations", ignore = true)
    })
    FinanceDB financeToFinanceDB(final Finance finance);

    @Mappings({
            @Mapping(target = "user.finance", ignore = true),
            @Mapping(target = "operations", ignore = true)
    })
    Finance financeDBToFinance(final FinanceDB financeDB);
}
