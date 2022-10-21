package com.financialctl.financialinfo.application.ports.outbound.repositories;

import com.financialctl.financialinfo.domain.models.User;

public interface UserRepository {

    User save(final User user);
}
