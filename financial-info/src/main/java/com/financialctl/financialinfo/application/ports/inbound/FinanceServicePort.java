package com.financialctl.financialinfo.application.ports.inbound;

import com.financialctl.financialinfo.domain.models.Finance;
import com.financialctl.financialinfo.domain.models.Operation;
import com.financialctl.financialinfo.domain.models.OperationFilter;

import java.util.List;

public interface FinanceServicePort {
    Finance get(final Long id);

    List<Operation> filterOperations(final OperationFilter filter);
}
