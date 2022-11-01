package com.financialctl.financialinfo.infrastructure.adapters.input.rest.dtos.finance;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotNull;

public class WindowDTO {

    @NotNull
    @Schema(
            description = "Filter operations from the start date (inclusive)",
            example = "2020-07-03TAmerica/Sao_Paulo"
    )
    private String fromDate;

    @NotNull
    @Schema(
            description = "Filter operations until the end date (inclusive)",
            example = "2020-08-03TAmerica/Sao_Paulo"
    )
    private String toDate;

    @Schema(
            description = "Filter operations from the amount",
            example = "13.13"
    )
    private Double fromAmount;

    @Schema(
            description = "Filter operations up to the amount",
            example = "14.14"
    )
    private Double toAmount;

    public WindowDTO() {
    }

    public WindowDTO(final String fromDate, final String toDate, final Double fromAmount, final Double toAmount) {
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.fromAmount = fromAmount;
        this.toAmount = toAmount;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(final String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(final String toDate) {
        this.toDate = toDate;
    }

    public Double getFromAmount() {
        return fromAmount;
    }

    public void setFromAmount(final Double fromAmount) {
        this.fromAmount = fromAmount;
    }

    public Double getToAmount() {
        return toAmount;
    }

    public void setToAmount(final Double toAmount) {
        this.toAmount = toAmount;
    }

    @Override
    public String toString() {
        return "Window{" +
                "fromDate=" + fromDate +
                ", toDate=" + toDate +
                ", fromAmount=" + fromAmount +
                ", toAmount=" + toAmount +
                '}';
    }
}
