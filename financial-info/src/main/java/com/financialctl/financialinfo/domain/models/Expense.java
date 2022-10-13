package com.financialctl.financialinfo.domain.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.financialctl.financialinfo.domain.models.enums.ExpenseType;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.ZonedDateTime;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "expense")
public class Expense {

    @Id
    @SequenceGenerator(
            name = "expense_sequence",
            sequenceName = "expense_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "expense_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "type",
            nullable = false
    )
    private ExpenseType type;

    @Column(
            name = "amount",
            nullable = false
    )
    private Double amount;

    @Column(
            name = "description",
            nullable = false
    )
    private String description;

    @Column(
            name = "date",
            nullable = false
    )
    private ZonedDateTime date;

    @ManyToOne
    @JoinColumn(
            name = "user_id",
            nullable = false
    )
    @JsonBackReference
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
