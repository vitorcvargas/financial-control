package com.financialctl.financialinfo.domain.services;

import com.financialctl.financialinfo.domain.models.User;
import com.financialctl.financialinfo.domain.repositories.UserRepository;
import com.financialctl.financialinfo.dtos.UserPostDto;
import com.financialctl.financialinfo.mappers.UserMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @InjectMocks
    UserService userService;

    @Mock
    UserRepository userRepository;

    @Mock
    UserMapper userMapper;

    @Test
    @DisplayName("Should save user when not already created")
    void shouldSaveUserWhenNotAlreadyCreated() {
        final UserPostDto userPostDto = new UserPostDto("Vitor", "vitor@email.com");

        userService.createUser(userPostDto);

        verify(userRepository, times(1)).save(any(User.class));
    }
}
