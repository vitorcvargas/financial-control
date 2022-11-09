package com.financialctl.financialinfo.domain.services;

import com.financialctl.financialinfo.application.ports.inbound.FinanceServicePort;
import com.financialctl.financialinfo.application.ports.outbound.repositories.FinanceRepository;
import com.financialctl.financialinfo.domain.models.Finance;
import com.financialctl.financialinfo.domain.models.Operation;
import com.financialctl.financialinfo.domain.models.OperationFilter;
import com.financialctl.financialinfo.domain.models.OperationTotal;
import com.financialctl.financialinfo.domain.models.enums.OperationEntry;
import com.financialctl.financialinfo.infrastructure.adapters.output.exceptions.NotFoundException;

import java.util.List;
import java.util.Map;

public class FinanceService implements FinanceServicePort {

    private final FinanceRepository financeRepository;

    public FinanceService(final FinanceRepository financeRepository) {
        this.financeRepository = financeRepository;
    }

    @Override
    public Finance get(final Long id) {
        return financeRepository.findById(id)
                .orElseThrow(() -> NotFoundException.financeNotFound(id));
    }

    @Override
    public List<Operation> filterOperations(final OperationFilter filter) {
        final Finance finance = financeRepository.findById(filter.getFinanceId())
                .orElseThrow(() -> NotFoundException.financeNotFound(filter.getFinanceId()));

        return finance.filterOperations(filter);
    }

    @Override
    public Map<OperationEntry, Double> createBudget(final Long id, final Map<OperationEntry, Double> budget) {
        return null;
    }

    @Override
    public void handleBudget(final Operation operation) {

    }
}
