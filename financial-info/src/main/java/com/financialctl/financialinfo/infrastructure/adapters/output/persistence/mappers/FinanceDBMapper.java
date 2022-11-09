package com.financialctl.financialinfo.infrastructure.adapters.output.persistence.mappers;

import com.financialctl.financialinfo.domain.models.Finance;
import com.financialctl.financialinfo.domain.models.OperationTotal;
import com.financialctl.financialinfo.domain.models.enums.OperationEntry;
import com.financialctl.financialinfo.infrastructure.adapters.output.persistence.entities.FinanceDB;
import com.financialctl.financialinfo.infrastructure.adapters.output.persistence.entities.OperationTotalDB;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FinanceDBMapper {

    FinanceDBMapper INSTANCE = Mappers.getMapper(FinanceDBMapper.class);

    FinanceDB financeToFinanceDB(final Finance finance, @Context CycleAvoidingMappingContext context);

    Finance financeDBToFinance(final FinanceDB financeDB, @Context CycleAvoidingMappingContext context);

    default OperationTotal operationTotalDBToOperationTotal(final OperationTotalDB operationTotalDB) {
        if (operationTotalDB == null) {
            return null;
        }

        final OperationTotal operationTotal = new OperationTotal();
        operationTotal.setTotal(operationTotalDB.getTotal());
        operationTotal.setFinanceId(operationTotalDB.getFinanceId());
        operationTotal.setOperation(OperationEntry.fromId(operationTotalDB.getOperation().getId()));

        return operationTotal;
    }
}
