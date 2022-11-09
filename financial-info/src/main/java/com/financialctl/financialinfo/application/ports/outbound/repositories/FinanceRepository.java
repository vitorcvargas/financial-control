package com.financialctl.financialinfo.application.ports.outbound.repositories;

import com.financialctl.financialinfo.domain.models.Finance;
import com.financialctl.financialinfo.domain.models.OperationTotal;

import java.util.Optional;

public interface FinanceRepository {
    Finance save(final Finance finance);

    Optional<Finance> findById(final Long id);

    OperationTotal getOperationTotalsByFinanceId(final Long financeId, final int operationEntryId);
}
