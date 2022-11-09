package com.financialctl.financialinfo.infrastructure.adapters.output.persistence.entities;

import com.financialctl.financialinfo.infrastructure.adapters.output.persistence.entities.enums.OperationEntryDB;

public interface OperationTotalDB {

    Long getFinanceId();

    OperationEntryDB getOperation();

    Double getTotal();
}
