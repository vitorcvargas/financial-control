package com.financialctl.financialinfo.domain.services;

import com.financialctl.financialinfo.domain.models.User;
import com.financialctl.financialinfo.domain.repositories.UserRepository;
import com.financialctl.financialinfo.dtos.UserDto;
import com.financialctl.financialinfo.dtos.UserPostDTO;
import com.financialctl.financialinfo.exceptions.BadRequestException;
import com.financialctl.financialinfo.mappers.UserMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto createUser(final UserPostDTO userPostDto) {
        try {
            final User user = UserMapper.INSTANCE.userPostDtoToUser(userPostDto);

            final User newUser = userRepository.save(user);

            return UserMapper.INSTANCE.userToUserDto(newUser);
        } catch (DataIntegrityViolationException ex) {
            throw BadRequestException.userAlreadyCreated(userPostDto.getEmail());
        }
    }
}
