package com.financialctl.financialinfo.infrastructure.adapters.output.persistence.repositories;

import com.financialctl.financialinfo.application.ports.outbound.repositories.UserRepository;
import com.financialctl.financialinfo.domain.models.User;
import com.financialctl.financialinfo.infrastructure.adapters.output.persistence.entities.UserDB;
import com.financialctl.financialinfo.infrastructure.adapters.output.persistence.mappers.UserDBMapper;
import com.financialctl.financialinfo.infrastructure.adapters.output.persistence.repositories.jpa.UserRepositoryJPA;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepositoryAdapter implements UserRepository {

    private final UserRepositoryJPA repository;

    public UserRepositoryAdapter(final UserRepositoryJPA repository) {
        this.repository = repository;
    }

    @Override
    public User save(final User user) {
        final UserDB newUserDB = repository.save(userDBToUser(user));
        return userDBToUser(newUserDB);
    }

    @Override
    public Optional<User> findById(final Long id) {
        final Optional<UserDB> optional = repository.findById(id);

        return Optional.ofNullable(userDBToUser(optional.orElse(null)));
    }

    @Override
    public void delete(final Long id) {
        repository.deleteById(id);
    }

    private User userDBToUser(final UserDB userDB) {
        return UserDBMapper.INSTANCE.userDBToUser(userDB);
    }

    private UserDB userDBToUser(final User user) {
        return UserDBMapper.INSTANCE.userToUserDB(user);
    }
}
