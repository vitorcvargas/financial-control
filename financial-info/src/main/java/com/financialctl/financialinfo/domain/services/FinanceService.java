package com.financialctl.financialinfo.domain.services;

import com.financialctl.financialinfo.application.ports.inbound.FinanceServicePort;
import com.financialctl.financialinfo.application.ports.outbound.repositories.FinanceRepository;
import com.financialctl.financialinfo.domain.models.Finance;
import com.financialctl.financialinfo.infrastructure.adapters.output.exceptions.NotFoundException;

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
}
