package com.financialctl.financialinfo.domain.services;

import com.financialctl.financialinfo.application.ports.inbound.UserServicePort;
import com.financialctl.financialinfo.application.ports.outbound.repositories.UserRepository;
import com.financialctl.financialinfo.domain.models.Finance;
import com.financialctl.financialinfo.domain.models.User;
import com.financialctl.financialinfo.infrastructure.adapters.output.exceptions.BadRequestException;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.Optional;


public class UserService implements UserServicePort {

    private final UserRepository userRepository;

    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(final User user) {
        try {
            final Finance finance = new Finance();
            user.addFinance(finance);

            return userRepository.save(user);
        } catch (DataIntegrityViolationException ex) {
            throw BadRequestException.userAlreadyCreated(user.getEmail());
        }
    }

    @Override
    public User get(final Long id) {
        final Optional<User> userOptional = userRepository.findById(id);

        return userOptional.orElse(null);
    }
}
