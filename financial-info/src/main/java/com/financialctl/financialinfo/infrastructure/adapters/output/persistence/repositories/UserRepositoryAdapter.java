package com.financialctl.financialinfo.infrastructure.adapters.output.persistence.repositories;

import com.financialctl.financialinfo.application.ports.outbound.repositories.UserRepository;
import com.financialctl.financialinfo.infrastructure.adapters.output.persistence.entity.UserDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryAdapter extends UserRepository, JpaRepository<UserDB, Long> {

    UserDB save(final UserDB user);
}
