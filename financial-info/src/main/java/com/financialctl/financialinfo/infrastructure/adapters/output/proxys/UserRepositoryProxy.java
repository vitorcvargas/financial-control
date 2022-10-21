package com.financialctl.financialinfo.infrastructure.adapters.output.proxys;

import com.financialctl.financialinfo.application.ports.outbound.repositories.UserRepository;
import com.financialctl.financialinfo.domain.models.User;
import com.financialctl.financialinfo.infrastructure.adapters.output.persistence.entity.UserDB;
import com.financialctl.financialinfo.infrastructure.adapters.output.persistence.mappers.UserDBMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
@Primary
public interface UserRepositoryProxy extends UserRepository, JpaRepository<UserDB, Long> {

    @Override
    default User save(final User user) {
        final UserDB userDB = UserDBMapper.INSTANCE.userToUserDB(user);
        return UserDBMapper.INSTANCE.userDBToUser(save(userDB));
    }
}
