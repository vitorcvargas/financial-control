package com.financialctl.financialinfo.application.ports.outbound.repositories;

import com.financialctl.financialinfo.domain.models.User;

import java.util.Optional;

public interface UserRepository extends CRUDRepository<User, Long> {

    Optional<User> findByEmail(final String email);
}
