package com.financialctl.financialinfo.domain.services;

import com.financialctl.financialinfo.application.ports.inbound.CRUDService;
import com.financialctl.financialinfo.application.ports.outbound.repositories.UserRepository;
import com.financialctl.financialinfo.domain.models.User;
import com.financialctl.financialinfo.infrastructure.adapters.output.exceptions.BadRequestException;
import org.springframework.dao.DataIntegrityViolationException;


public class UserService implements CRUDService<User, User> {

    private final UserRepository userRepository;

    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(final User user) {
        try {
            return userRepository.save(user);
        } catch (DataIntegrityViolationException ex) {
            throw BadRequestException.userAlreadyCreated(user.getEmail());
        }
    }
}
