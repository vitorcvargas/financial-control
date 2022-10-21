package com.financialctl.financialinfo.infrastructure.adapters.output.persistence.repositories;

import com.financialctl.financialinfo.application.ports.outbound.repositories.ExpenseRepository;
import com.financialctl.financialinfo.infrastructure.adapters.output.persistence.entity.ExpenseDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepositoryAdapter extends ExpenseRepository, JpaRepository<ExpenseDB, Long> {
}
