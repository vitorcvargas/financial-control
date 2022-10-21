package com.financialctl.financialinfo.domain.models;

import java.util.List;


public class User {

    private Long id;
    private String name;
    private String email;
    private List<Expense> expenses;
    private List<Income> incomes;

    public User() {
    }

    public User(final String name, final String email) {
        this.name = name;
        this.email = email;
    }

    public User(final Long id, final String name, final String email, final List<Expense> expenses, final List<Income> incomes) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.expenses = expenses;
        this.incomes = incomes;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(final List<Expense> expenses) {
        this.expenses = expenses;
    }

    public List<Income> getIncomes() {
        return incomes;
    }

    public void setIncomes(final List<Income> incomes) {
        this.incomes = incomes;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", expenses=" + expenses +
                ", incomes=" + incomes +
                '}';
    }
}
