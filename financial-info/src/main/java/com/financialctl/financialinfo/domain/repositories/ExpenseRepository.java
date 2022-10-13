package com.financialctl.financialinfo.domain.repositories;

import com.financialctl.financialinfo.domain.models.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}
