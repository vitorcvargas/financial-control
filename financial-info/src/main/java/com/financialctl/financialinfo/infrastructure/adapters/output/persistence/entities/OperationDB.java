package com.financialctl.financialinfo.infrastructure.adapters.output.persistence.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.financialctl.financialinfo.infrastructure.adapters.output.persistence.entities.enums.OperationEntryDB;

import javax.persistence.*;
import java.time.ZonedDateTime;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "operation")
public class OperationDB {


    @Id
    @SequenceGenerator(
            name = "operation_sequence",
            sequenceName = "operation_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "operation_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

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

    @Column(name = "operation")
    private OperationEntryDB operationEntryType;

    @ManyToOne
    @JoinColumn(
            name = "finance_id",
            nullable = false
    )
    @JsonIgnore
    private FinanceDB finance;

    public OperationDB() {
    }

    public OperationDB(final Double amount, final String description, final ZonedDateTime date, final OperationEntryDB operationEntryType, final FinanceDB finance) {
        this.amount = amount;
        this.description = description;
        this.date = date;
        this.operationEntryType = operationEntryType;
        this.finance = finance;
    }

    public OperationDB(final Long id, final Double amount, final String description, final ZonedDateTime date, final OperationEntryDB operationEntryType, final FinanceDB finance) {
        this.id = id;
        this.amount = amount;
        this.description = description;
        this.date = date;
        this.operationEntryType = operationEntryType;
        this.finance = finance;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
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

    public OperationEntryDB getOperationEntryType() {
        return operationEntryType;
    }

    public void setOperationEntryType(final OperationEntryDB operationEntryType) {
        this.operationEntryType = operationEntryType;
    }

    public FinanceDB getFinance() {
        return finance;
    }

    public void setFinance(final FinanceDB finance) {
        this.finance = finance;
    }

    @Override
    public String toString() {
        return "OperationDB{" +
                "id=" + id +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", operationEntry=" + operationEntryType +
                ", finance=" + finance +
                '}';
    }
}
