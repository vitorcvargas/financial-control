package com.financialctl.financialinfo.domain.services;

import com.financialctl.financialinfo.application.ports.inbound.FinanceServicePort;
import com.financialctl.financialinfo.application.ports.inbound.OperationServicePort;
import com.financialctl.financialinfo.application.ports.outbound.repositories.OperationRepository;
import com.financialctl.financialinfo.domain.models.Finance;
import com.financialctl.financialinfo.domain.models.Operation;
import com.financialctl.financialinfo.infrastructure.adapters.output.exceptions.NotFoundException;

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
    public Operation update(final Operation operation) {
        final Operation operationToUpdate = get(operation.getId());

        updateValues(operation, operationToUpdate);

        return operationRepository.save(operationToUpdate);
    }

    @Override
    public void delete(final Long id) {
        final Optional<Operation> optionalOperation = operationRepository.findById(id);

        if (optionalOperation.isEmpty())
            throw NotFoundException.operationNotFound(id);

        operationRepository.delete(id);
    }

    private void updateValues(final Operation operation, final Operation operationToUpdate) {
        operationToUpdate.setDescription(operation.getDescription());
        operationToUpdate.setDate(operation.getDate());
        operationToUpdate.setAmount(operation.getAmount());
        operationToUpdate.setOperationEntryType(operation.getOperationEntryType());
    }

    @Override
    public Operation get(final Long id) {
        return operationRepository.findById(id)
                .orElseThrow(() -> NotFoundException.operationNotFound(id));
    }
}
