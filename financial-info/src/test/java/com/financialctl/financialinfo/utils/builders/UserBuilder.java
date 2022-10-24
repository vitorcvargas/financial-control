package com.financialctl.financialinfo.utils.builders;

import com.financialctl.financialinfo.domain.models.Finance;
import com.financialctl.financialinfo.domain.models.User;

public class UserBuilder {
    private Long id;
    private String name;
    private String email;
    private Finance finance;

    public static UserBuilder getBuilder() {
        return new UserBuilder();
    }

    public UserBuilder id(final Long id) {
        this.id = id;
        return this;
    }

    public UserBuilder name(final String name) {
        this.name = name;
        return this;
    }

    public UserBuilder email(final String email) {
        this.email = email;
        return this;
    }

    public UserBuilder finance(final Finance finance) {
        this.finance = finance;
        return this;
    }

    public User build() {
        return new User(this.id, this.name, this.email, this.finance);
    }
}
