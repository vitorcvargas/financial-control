package com.financialctl.financialinfo.application.ports.inbound;

import com.financialctl.financialinfo.domain.models.Finance;
import com.financialctl.financialinfo.domain.models.Operation;
import com.financialctl.financialinfo.domain.models.OperationFilter;
import com.financialctl.financialinfo.domain.models.enums.OperationEntry;

import java.util.List;
import java.util.Map;

public interface FinanceServicePort {

    Finance get(final Long id);

    List<Operation> filterOperations(final OperationFilter filter);

    Map<OperationEntry, Double> createBudget(final Long id, final Map<OperationEntry, Double> budget);

    void handleBudget(Operation operation);
}
