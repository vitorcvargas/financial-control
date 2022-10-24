package com.financialctl.financialinfo.infrastructure.adapters.output.persistence.repositories;

import com.financialctl.financialinfo.application.ports.outbound.repositories.FinanceRepository;
import com.financialctl.financialinfo.domain.models.Finance;
import com.financialctl.financialinfo.infrastructure.adapters.output.persistence.entities.FinanceDB;
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
        final Finance finance = financeDBToFinance(repository.findById(id).get());
        return Optional.of(finance);
    }

    @Override
    public Finance save(final Finance finance) {
        final FinanceDB newFinanceDB = repository.save(financeToFinanceDB(finance));
        return financeDBToFinance(newFinanceDB);
    }

    private Finance financeDBToFinance(final FinanceDB financeDB) {
        return FinanceDBMapper.INSTANCE.financeDBToFinance(financeDB);
    }

    private FinanceDB financeToFinanceDB(final Finance finance) {
        return FinanceDBMapper.INSTANCE.financeToFinanceDB(finance);
    }
}
