package com.financialctl.financialinfo.infrastructure.adapters.output.persistence.repositories;

import com.financialctl.financialinfo.application.ports.outbound.repositories.IncomeRepository;
import com.financialctl.financialinfo.infrastructure.adapters.output.persistence.entity.IncomeDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomeRepositoryAdapter extends IncomeRepository, JpaRepository<IncomeDB, Long> {
}
