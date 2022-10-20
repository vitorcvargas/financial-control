package com.financialctl.financialinfo.domain.services;

import com.financialctl.financialinfo.domain.models.User;
import com.financialctl.financialinfo.domain.repositories.UserRepository;
import com.financialctl.financialinfo.dtos.UserPostDTO;
import com.financialctl.financialinfo.exceptions.BadRequestException;
import com.financialctl.financialinfo.mappers.UserMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DataIntegrityViolationException;

import static org.junit.jupiter.api.Assertions.assertThrows;
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
        final UserPostDTO userPostDto = new UserPostDTO("Vitor", "vitor@email.com");

        userService.createUser(userPostDto);

        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    @DisplayName("Should throw exception when user is already created")
    void shouldThrowExceptionWhenUserAlreadyCreated() {
        final UserPostDTO userPostDto = new UserPostDTO("Vitor", "vitor@email.com");

        when(userRepository.save(any(User.class)))
                .thenThrow(DataIntegrityViolationException.class);

        assertThrows(BadRequestException.class, () -> userService.createUser(userPostDto));
    }
}
