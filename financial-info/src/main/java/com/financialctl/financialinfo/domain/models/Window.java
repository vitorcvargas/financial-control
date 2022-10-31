package com.financialctl.financialinfo.domain.models;

import java.time.ZonedDateTime;

public class Window {

    private ZonedDateTime fromDate;
    private ZonedDateTime toDate;
    private Double fromAmount;
    private Double toAmount;

    public Window() {
    }

    public Window(final ZonedDateTime fromDate, final ZonedDateTime toDate, final Double fromAmount, final Double toAmount) {
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.fromAmount = fromAmount;
        this.toAmount = toAmount;
    }

    public ZonedDateTime getFromDate() {
        return fromDate;
    }

    public void setFromDate(final ZonedDateTime fromDate) {
        this.fromDate = fromDate;
    }

    public ZonedDateTime getToDate() {
        return toDate;
    }

    public void setToDate(final ZonedDateTime toDate) {
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
