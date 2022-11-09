package com.financialctl.financialinfo.infrastructure.adapters.output.persistence.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.financialctl.financialinfo.infrastructure.adapters.output.persistence.entities.enums.OperationEntryDB;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

import static javax.persistence.CascadeType.ALL;

@Entity
@Table(name = "finance")
public class FinanceDB {

    @Id
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    @JsonIgnore
    private UserDB user;

    @OneToMany(
            cascade = ALL,
            mappedBy = "finance"
    )
    private List<OperationDB> operations;

    @ElementCollection
    @CollectionTable(name = "budget", joinColumns = @JoinColumn(name = "finance_id"))
    @MapKeyColumn(name = "entry_type")
    @Column(name = "budget_limit")
    private Map<OperationEntryDB, Double> budget;

    public FinanceDB() {
    }

    public FinanceDB(final UserDB user, final List<OperationDB> operations) {
        this.user = user;
        this.operations = operations;
    }

    public FinanceDB(final Long id, final UserDB user, final List<OperationDB> operations, final Map<OperationEntryDB, Double> budget) {
        this.id = id;
        this.user = user;
        this.operations = operations;
        this.budget = budget;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public UserDB getUser() {
        return user;
    }

    public void setUser(final UserDB user) {
        this.user = user;
    }

    public List<OperationDB> getOperations() {
        return operations;
    }

    public void setOperations(final List<OperationDB> operations) {
        this.operations = operations;
    }

    public Map<OperationEntryDB, Double> getBudget() {
        return budget;
    }

    public void setBudget(final Map<OperationEntryDB, Double> budget) {
        this.budget = budget;
    }

    @Override
    public String toString() {
        return "FinanceDB{" +
                "id=" + id +
                ", user=" + user +
                ", operations=" + operations +
                ", budget=" + budget +
                '}';
    }
}
