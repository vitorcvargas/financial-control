package com.financialctl.financialinfo.application.ports.outbound.repositories;

import com.financialctl.financialinfo.domain.models.Finance;

import java.util.Optional;

public interface FinanceRepository {
    Optional<Finance> findById(final Long id);
}
