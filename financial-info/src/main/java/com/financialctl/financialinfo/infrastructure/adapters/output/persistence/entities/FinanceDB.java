package com.financialctl.financialinfo.infrastructure.adapters.output.persistence.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "finance")
public class FinanceDB {

    @Id
    @SequenceGenerator(
            name = "finance_sequence",
            sequenceName = "finance_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "finance_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @OneToOne
    @PrimaryKeyJoinColumn
    @JsonBackReference
    private UserDB user;

    @OneToMany(
            cascade = ALL,
            mappedBy = "finance"
    )
    @JsonManagedReference
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
