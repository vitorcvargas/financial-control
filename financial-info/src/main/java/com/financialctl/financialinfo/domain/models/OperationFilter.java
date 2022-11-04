package com.financialctl.financialinfo.domain.models;

import com.financialctl.financialinfo.domain.models.enums.OperationEntry;
import com.financialctl.financialinfo.domain.models.enums.OperationType;

import java.util.List;

public class OperationFilter {

    private Long financeId;
    private OperationType operationType;
    private List<OperationEntry> operationEntryTypes;
    private Window window;
    private List<String> descriptions;

    public OperationFilter() {
    }

    public OperationFilter(final Long financeId, final OperationType operationType, final List<OperationEntry> operationEntryTypes, final Window window, final List<String> descriptions) {
        this.financeId = financeId;
        this.operationType = operationType;
        this.operationEntryTypes = operationEntryTypes;
        this.window = window;
        this.descriptions = descriptions;
    }

    public List<OperationEntry> getOperationEntryTypes() {
        return operationEntryTypes;
    }

    public void setOperationEntryTypes(final List<OperationEntry> operationEntryTypes) {
        this.operationEntryTypes = operationEntryTypes;
    }

    public Window getWindow() {
        return window;
    }

    public void setWindow(final Window window) {
        this.window = window;
    }

    public List<String> getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(final List<String> descriptions) {
        this.descriptions = descriptions;
    }

    public Long getFinanceId() {
        return financeId;
    }

    public void setFinanceId(final Long financeId) {
        this.financeId = financeId;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public void setOperationType(final OperationType operationType) {
        this.operationType = operationType;
    }

    @Override
    public String toString() {
        return "OperationFilter{" +
                "financeId=" + financeId +
                ", operationType=" + operationType +
                ", operationEntryTypes=" + operationEntryTypes +
                ", window=" + window +
                ", descriptions=" + descriptions +
                '}';
    }
}
