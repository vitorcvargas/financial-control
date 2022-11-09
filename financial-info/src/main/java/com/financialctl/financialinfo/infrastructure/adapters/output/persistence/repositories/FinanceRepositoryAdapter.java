package com.financialctl.financialinfo.infrastructure.adapters.output.persistence.repositories;

import com.financialctl.financialinfo.application.ports.outbound.repositories.FinanceRepository;
import com.financialctl.financialinfo.domain.models.Finance;
import com.financialctl.financialinfo.domain.models.OperationTotal;
import com.financialctl.financialinfo.infrastructure.adapters.output.persistence.entities.FinanceDB;
import com.financialctl.financialinfo.infrastructure.adapters.output.persistence.mappers.CycleAvoidingMappingContext;
import com.financialctl.financialinfo.infrastructure.adapters.output.persistence.mappers.FinanceDBMapper;
import com.financialctl.financialinfo.infrastructure.adapters.output.persistence.repositories.jpa.FinanceRepositoryJPA;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class FinanceRepositoryAdapter implements FinanceRepository {

    private final FinanceRepositoryJPA repository;

    public FinanceRepositoryAdapter(final FinanceRepositoryJPA repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Finance> findById(final Long id) {
        final Optional<FinanceDB> optional = repository.findById(id);

        return Optional.ofNullable(financeDBToFinance(optional.orElse(null)));
    }

    @Override
    public Finance save(final Finance finance) {
        final FinanceDB financeDB = financeToFinanceDB(finance);
        return financeDBToFinance(repository.save(financeDB));
    }

    @Override
    public OperationTotal getOperationTotalsByFinanceId(final Long financeId, final int operationEntryId) {
        return FinanceDBMapper.INSTANCE.operationTotalDBToOperationTotal(repository.getOperationTotalsByFinanceId(financeId, operationEntryId));
    }

    private Finance financeDBToFinance(final FinanceDB financeDB) {
        return FinanceDBMapper.INSTANCE.financeDBToFinance(financeDB, new CycleAvoidingMappingContext());
    }

    private FinanceDB financeToFinanceDB(final Finance finance) {
        return FinanceDBMapper.INSTANCE.financeToFinanceDB(finance, new CycleAvoidingMappingContext());
    }
}
