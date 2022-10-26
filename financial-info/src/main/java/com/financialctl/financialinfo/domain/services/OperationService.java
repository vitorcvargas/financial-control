package com.financialctl.financialinfo.domain.services;

import com.financialctl.financialinfo.application.ports.inbound.FinanceServicePort;
import com.financialctl.financialinfo.application.ports.inbound.OperationServicePort;
import com.financialctl.financialinfo.application.ports.outbound.repositories.OperationRepository;
import com.financialctl.financialinfo.domain.models.Finance;
import com.financialctl.financialinfo.domain.models.Operation;

import java.util.Optional;

public class OperationService implements OperationServicePort {

    private final OperationRepository operationRepository;
    private final FinanceServicePort financeService;

    public OperationService(final OperationRepository operationRepository, final FinanceServicePort financeService) {
        this.operationRepository = operationRepository;
        this.financeService = financeService;
    }

    @Override
    public Operation save(final Operation operation) {
        final Finance finance = financeService.get(operation.getFinance().getId());
        operation.setFinance(finance);
        return operationRepository.save(operation);
    }

    @Override
    public Operation get(final Long id) {
        final Optional<Operation> operationOptional = operationRepository.findById(id);

        return operationOptional.orElse(null);
    }
}
