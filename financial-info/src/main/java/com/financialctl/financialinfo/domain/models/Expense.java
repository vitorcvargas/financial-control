package com.financialctl.financialinfo.domain.models;

import com.financialctl.financialinfo.domain.models.enums.ExpenseType;

import java.time.ZonedDateTime;


public class Expense {


    private Long id;
    private ExpenseType type;
    private Double amount;
    private String description;
    private ZonedDateTime date;
    private User user;

    public Expense() {
    }

    public Expense(final Long id, final ExpenseType type, final Double amount, final String description, final ZonedDateTime date, final User user) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.description = description;
        this.date = date;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public ExpenseType getType() {
        return type;
    }

    public void setType(final ExpenseType type) {
        this.type = type;
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

    public User getUser() {
        return user;
    }

    public void setUser(final User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", type=" + type +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", user=" + user +
                '}';
    }
}
