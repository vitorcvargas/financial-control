package com.financialctl.financialinfo.domain.models;

import java.util.List;

public class Finance {

    private Long id;
    private User user;
    private List<Operation> operations;

    public Finance() {
    }

    public Finance(final User user, final List<Operation> operations) {
        this.user = user;
        this.operations = operations;
    }

    public Finance(final Long id, final User user, final List<Operation> operations) {
        this.id = id;
        this.user = user;
        this.operations = operations;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(final User user) {
        this.user = user;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(final List<Operation> operations) {
        this.operations = operations;
    }

    @Override
    public String toString() {
        return "Finance{" +
                "id=" + id +
                ", user=" + user +
                ", operations=" + operations +
                '}';
    }
}
