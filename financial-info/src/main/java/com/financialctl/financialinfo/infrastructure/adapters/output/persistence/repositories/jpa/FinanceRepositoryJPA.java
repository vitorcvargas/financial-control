package com.financialctl.financialinfo.infrastructure.adapters.output.persistence.repositories.jpa;

import com.financialctl.financialinfo.infrastructure.adapters.output.persistence.entities.FinanceDB;
import com.financialctl.financialinfo.infrastructure.adapters.output.persistence.entities.OperationTotalDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

@Component
public interface FinanceRepositoryJPA extends JpaRepository<FinanceDB, Long> {

    @Query(value = "SELECT " +
            "o.finance_id as financeId, " +
            "o.operation, " +
            "sum(o.amount) as total " +
            "FROM " +
            "operation o, " +
            "finance f " +
            "WHERE f.id = o.finance_id  " +
            "AND MONTH(o.operation_date)=MONTH(now()) " +
            "AND YEAR(o.operation_date)=YEAR(now()) " +
            "AND f.id = ?1 " +
            "GROUP BY o.operation",
            nativeQuery = true
    )
    OperationTotalDB getOperationTotalsByFinanceId(final Long id, final int operationEntryId);
}
