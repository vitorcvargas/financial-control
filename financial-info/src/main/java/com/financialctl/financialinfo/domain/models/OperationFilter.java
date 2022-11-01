package com.financialctl.financialinfo.domain.models;

import com.financialctl.financialinfo.domain.models.enums.OperationEntry;

import java.util.List;

public class OperationFilter {

    private Long financeId;
    private List<OperationEntry> operationEntryTypes;
    private Window window;
    private List<String> descriptions;

    public OperationFilter() {
    }

    public OperationFilter(final Long financeId, final List<OperationEntry> operationEntryTypes, final Window window, final List<String> descriptions) {
        this.financeId = financeId;
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

    @Override
    public String toString() {
        return "OperationFilter{" +
                "financeId=" + financeId +
                ", operationEntryTypes=" + operationEntryTypes +
                ", window=" + window +
                ", description=" + descriptions +
                '}';
    }
}
