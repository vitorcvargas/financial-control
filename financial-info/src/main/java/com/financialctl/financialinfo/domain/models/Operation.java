package com.financialctl.financialinfo.domain.models;

import com.financialctl.financialinfo.domain.models.enums.OperationEntry;

import java.time.ZonedDateTime;

public class Operation {

    private Long id;
    private Double amount;
    private String description;
    private ZonedDateTime date;
    private OperationEntry operationEntryType;
    private Finance finance;

    public Operation() {
    }

    public Operation(final Double amount, final String description, final ZonedDateTime date, final OperationEntry operationEntryType, final Finance finance) {
        this.amount = amount;
        this.description = description;
        this.date = date;
        this.operationEntryType = operationEntryType;
        this.finance = finance;
    }

    public Operation(final Long id, final Double amount, final String description, final ZonedDateTime date, final OperationEntry operationEntryType, final Finance finance) {
        this.id = id;
        this.amount = amount;
        this.description = description;
        this.date = date;
        this.operationEntryType = operationEntryType;
        this.finance = finance;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(final Double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public ZonedDateTime getDate() {
        return date;
    }

    public void setDate(final ZonedDateTime date) {
        this.date = date;
    }

    public OperationEntry getOperationEntryType() {
        return operationEntryType;
    }

    public void setOperationEntryType(final OperationEntry operationEntryType) {
        this.operationEntryType = operationEntryType;
    }

    public Finance getFinance() {
        return finance;
    }

    public void setFinance(final Finance finance) {
        this.finance = finance;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "id=" + id +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", operationEntry=" + operationEntryType +
                ", finance=" + finance +
                '}';
    }
}
