package com.financialctl.financialinfo.domain.repositories;

import com.financialctl.financialinfo.domain.models.Income;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncomeRepository extends JpaRepository<Income, Long> {
}
