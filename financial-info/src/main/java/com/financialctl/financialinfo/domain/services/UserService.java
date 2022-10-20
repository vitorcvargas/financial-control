package com.financialctl.financialinfo.domain.services;

import com.financialctl.financialinfo.domain.models.User;
import com.financialctl.financialinfo.domain.repositories.UserRepository;
import com.financialctl.financialinfo.dtos.UserPostDTO;
import com.financialctl.financialinfo.exceptions.BadRequestException;
import com.financialctl.financialinfo.mappers.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    private final Logger logger = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;

    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(final UserPostDTO userPostDto) {
        try {
            final User user = UserMapper.INSTANCE.userPostDtoToUser(userPostDto);
            userRepository.save(user);
        } catch (DataIntegrityViolationException ex) {
            throw BadRequestException.userAlreadyCreated(userPostDto.getEmail());
        }
    }
}
