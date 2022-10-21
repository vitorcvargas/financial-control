package com.financialctl.financialinfo.infrastructure.adapters.output.persistence.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.financialctl.financialinfo.infrastructure.adapters.output.persistence.entity.enums.IncomeTypeDB;

import javax.persistence.*;
import java.time.ZonedDateTime;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "income")
public class IncomeDB {

    @Id
    @SequenceGenerator(
            name = "income_sequence",
            sequenceName = "income_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "income_sequence"
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
    private IncomeTypeDB type;

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
    private UserDB userDB;

    public IncomeDB() {
    }

    public IncomeDB(final Long id, final IncomeTypeDB type, final Double amount, final String description, final ZonedDateTime date, final UserDB userDB) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.description = description;
        this.date = date;
        this.userDB = userDB;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public IncomeTypeDB getType() {
        return type;
    }

    public void setType(final IncomeTypeDB type) {
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

    public UserDB getUser() {
        return userDB;
    }

    public void setUser(final UserDB userDB) {
        this.userDB = userDB;
    }

    @Override
    public String toString() {
        return "Income{" +
                "id=" + id +
                ", type=" + type +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", user=" + userDB +
                '}';
    }
}
