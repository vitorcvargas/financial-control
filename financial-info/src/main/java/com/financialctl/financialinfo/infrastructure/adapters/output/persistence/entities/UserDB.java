package com.financialctl.financialinfo.infrastructure.adapters.output.persistence.entity;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "user")
public class UserDB {

    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "user_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(
            name = "email",
            unique = true
    )
    private String email;

    @OneToMany(
            cascade = ALL,
            mappedBy = "userDB"
    )
    private List<ExpenseDB> expens;

    @OneToMany(
            cascade = ALL,
            mappedBy = "userDB"
    )
    private List<IncomeDB> incomeDBS;

    public UserDB() {
    }

    public UserDB(final String name, final String email) {
        this.name = name;
        this.email = email;
    }

    public UserDB(final Long id, final String name, final String email, final List<ExpenseDB> expens, final List<IncomeDB> incomeDBS) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.expens = expens;
        this.incomeDBS = incomeDBS;
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

    public List<ExpenseDB> getExpenses() {
        return expens;
    }

    public void setExpenses(final List<ExpenseDB> expens) {
        this.expens = expens;
    }

    public List<IncomeDB> getIncomes() {
        return incomeDBS;
    }

    public void setIncomes(final List<IncomeDB> incomeDBS) {
        this.incomeDBS = incomeDBS;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", expenses=" + expens +
                ", incomes=" + incomeDBS +
                '}';
    }
}
