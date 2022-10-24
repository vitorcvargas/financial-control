package com.financialctl.financialinfo.infrastructure.adapters.output.persistence.repositories.jpa;

import com.financialctl.financialinfo.infrastructure.adapters.output.persistence.entities.UserDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserRepositoryJPA extends JpaRepository<UserDB, Long> {
}
