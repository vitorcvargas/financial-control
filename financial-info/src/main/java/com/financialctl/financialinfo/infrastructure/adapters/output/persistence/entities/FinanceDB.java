package com.financialctl.financialinfo.infrastructure.adapters.output.persistence.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

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

    public FinanceDB() {
    }

    public FinanceDB(final UserDB user, final List<OperationDB> operations) {
        this.user = user;
        this.operations = operations;
    }

    public FinanceDB(final Long id, final UserDB user, final List<OperationDB> operations) {
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

    @Override
    public String toString() {
        return "FinanceDB{" +
                "id=" + id +
                ", user=" + user +
                ", operations=" + operations +
                '}';
    }
}
