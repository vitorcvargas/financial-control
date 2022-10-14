package com.financialctl.financialinfo.domain.services;

import com.financialctl.financialinfo.domain.models.User;
import com.financialctl.financialinfo.domain.repositories.UserRepository;
import com.financialctl.financialinfo.dtos.UserPostDto;
import com.financialctl.financialinfo.mappers.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(final UserPostDto userPostDto) {
        final User user = UserMapper.INSTANCE.userPostDtoToUser(userPostDto);
        userRepository.save(user);
    }
}
