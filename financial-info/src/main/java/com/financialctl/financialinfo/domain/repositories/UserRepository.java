package com.financialctl.financialinfo.domain.repositories;

import com.financialctl.financialinfo.domain.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
