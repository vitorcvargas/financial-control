package com.financialctl.financialinfo.infrastructure.adapters.input.rest.dtos.operation;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.financialctl.financialinfo.domain.models.enums.OperationEntry;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.ZonedDateTime;

public class OperationResponseDTO {

    @Schema(
            description = "Operation id",
            example = "1"
    )
    private Long id;

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

    @Schema(
            description = "Operation date",
            example = "2020-07-03@01:03:34.467+08:00"
    )
    private ZonedDateTime date;

    @Schema(
            description = "Operation entry type",
            example = "2020-07-03@01:03:34.467+08:00"
    )
    @JsonProperty("operation_type")
    private OperationEntry operationEntryType;

    @Schema(
            description = "Finance id",
            example = "1"
    )
    @JsonProperty("finance_id")
    private Long financeId;

    public OperationResponseDTO() {
    }

    public OperationResponseDTO(final Long id, final Double amount, final String description, final ZonedDateTime date, final OperationEntry operationEntryType, final Long financeId) {
        this.id = id;
        this.amount = amount;
        this.description = description;
        this.date = date;
        this.operationEntryType = operationEntryType;
        this.financeId = financeId;
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

    public Long getFinanceId() {
        return financeId;
    }

    public void setFinanceId(final Long financeId) {
        this.financeId = financeId;
    }

    @Override
    public String toString() {
        return "OperationResponseDTO{" +
                "id=" + id +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", operationEntry=" + operationEntryType +
                ", finance=" + financeId +
                '}';
    }
}
