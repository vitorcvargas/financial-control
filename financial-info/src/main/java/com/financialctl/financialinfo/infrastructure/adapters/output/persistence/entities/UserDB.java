package com.financialctl.financialinfo.infrastructure.adapters.output.persistence.entities;

import javax.persistence.*;

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

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private FinanceDB finance;

    public UserDB() {
    }

    public UserDB(final Long id, final String name, final String email, final FinanceDB finance) {
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

    public FinanceDB getFinance() {
        return finance;
    }

    public void setFinance(final FinanceDB finance) {
        this.finance = finance;
    }

    @Override
    public String toString() {
        return "UserDB{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", finance=" + finance +
                '}';
    }
}
