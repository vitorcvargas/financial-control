package com.financialctl.financialinfo.domain.services;

import com.financialctl.financialinfo.application.ports.inbound.FinanceServicePort;
import com.financialctl.financialinfo.application.ports.outbound.repositories.FinanceRepository;
import com.financialctl.financialinfo.domain.models.Finance;

import java.util.Optional;

public class FinanceService implements FinanceServicePort {

    private final FinanceRepository financeRepository;

    public FinanceService(final FinanceRepository financeRepository) {
        this.financeRepository = financeRepository;
    }

    @Override
    public Finance save(final Finance obj) {
        return null;
    }

    @Override
    public Finance get(final Long id) {
        final Optional<Finance> financeOptional = financeRepository.findById(id);

        return financeOptional.orElse(null);
    }
}
