package com.financialctl.financialinfo.infrastructure.adapters.input.rest.dtos.operation;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.ZonedDateTimeSerializer;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;

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
            example = "2020-07-03@01:03:34.467+08:00"
    )
    @JsonFormat(pattern = "yyyy-MM-dd@HH:mm:ss.SSSXXX")
    @JsonSerialize(using = ZonedDateTimeSerializer.class)
    private ZonedDateTime date;

    @NotNull
    @Schema(
            description = "Operation entry type",
            example = "1"
    )
    @JsonProperty("operation_entry")
    private int operationEntryType;

    @NotNull
    @Schema(
            description = "Finance id",
            example = "1"
    )
    @JsonProperty("finance_id")
    private Long financeId;

    public OperationRequestDTO() {
    }

    public OperationRequestDTO(final Double amount, final String description, final ZonedDateTime date, final int operationEntryType, final Long financeId) {
        this.amount = amount;
        this.description = description;
        this.date = date;
        this.operationEntryType = operationEntryType;
        this.financeId = financeId;
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

    public int getOperationEntryType() {
        return operationEntryType;
    }

    public void setOperationEntryType(final int operationEntryType) {
        this.operationEntryType = operationEntryType;
    }

    public Long getFinanceId() {
        return financeId;
    }

    public void setFinance(final Long financeId) {
        this.financeId = financeId;
    }

    @Override
    public String toString() {
        return "OperationRequestDTO{" +
                "amount=" + amount +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", operationEntry=" + operationEntryType +
                ", financeId=" + financeId +
                '}';
    }
}
