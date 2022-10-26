package com.financialctl.financialinfo.domain.models;

public class User {

    private Long id;
    private String name;
    private String email;
    private Finance finance;

    public void addFinance(final Finance finance) {
        finance.setUser(this);
        this.setFinance(finance);
    }

    public User() {
    }

    public User(final String name, final String email, final Finance finance) {
        this.name = name;
        this.email = email;
        this.finance = finance;
    }

    public User(final Long id, final String name, final String email, final Finance finance) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.finance = finance;
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

    public Finance getFinance() {
        return finance;
    }

    public void setFinance(final Finance finance) {
        this.finance = finance;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", finance=" + finance +
                '}';
    }
}
