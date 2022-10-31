package com.financialctl.financialinfo.infrastructure.adapters.input.rest.dtos.operation;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.financialctl.financialinfo.infrastructure.adapters.input.rest.dtos.finance.FinanceDTO;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotNull;

public class OperationRequestDTO {

    @NotNull
    @Schema(
            description = "Operation amount",
            example = "13.13"
    )
    private Double amount;

    @Schema(
            description = "Operation description",
            example = "Outback"
    )
    private String description;

    @NotNull
    @Schema(
            description = "Operation date",
            example = "2020-07-03TAmerica/Sao_Paulo"
    )
    private String date;

    @NotNull
    @Schema(
            description = "Operation entry type",
            example = "TRANSPORTATION"
    )
    @JsonProperty("operation_entry")
    private String operationEntryType;

    @NotNull
    private FinanceDTO finance;

    public OperationRequestDTO() {
    }

    public OperationRequestDTO(final Double amount, final String description, final String date, final String operationEntryType, final FinanceDTO finance) {
        this.amount = amount;
        this.description = description;
        this.date = date;
        this.operationEntryType = operationEntryType;
        this.finance = finance;
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

    public String getDate() {
        return date;
    }

    public void setDate(final String date) {
        this.date = date;
    }

    public String getOperationEntryType() {
        return operationEntryType;
    }

    public void setOperationEntryType(final String operationEntryType) {
        this.operationEntryType = operationEntryType;
    }

    public FinanceDTO getFinance() {
        return finance;
    }

    public void setFinance(final FinanceDTO finance) {
        this.finance = finance;
    }

    @Override
    public String toString() {
        return "OperationRequestDTO{" +
                "amount=" + amount +
                ", description='" + description + '\'' +
                ", date='" + date + '\'' +
                ", operationEntryType=" + operationEntryType +
                ", finance=" + finance +
                '}';
    }
}
