package com.financialctl.financialinfo.domain.models;

import com.financialctl.financialinfo.domain.models.enums.OperationEntry;

public class OperationTotal {
    private Long financeId;
    private OperationEntry operation;
    private Double total;

    public OperationTotal() {
    }

    public OperationTotal(final Long financeId, final OperationEntry operation, final Double total) {
        this.financeId = financeId;
        this.operation = operation;
        this.total = total;
    }

    public Long getFinanceId() {
        return financeId;
    }

    public void setFinanceId(final Long financeId) {
        this.financeId = financeId;
    }

    public OperationEntry getOperation() {
        return operation;
    }

    public void setOperation(final OperationEntry operation) {
        this.operation = operation;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(final Double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "OperationTotal{" +
                "financeId=" + financeId +
                ", operation=" + operation +
                ", total=" + total +
                '}';
    }
}
