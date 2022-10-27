package com.financialctl.financialinfo.domain.services;

import com.financialctl.financialinfo.application.ports.outbound.repositories.UserRepository;
import com.financialctl.financialinfo.domain.models.Finance;
import com.financialctl.financialinfo.domain.models.Operation;
import com.financialctl.financialinfo.domain.models.User;
import com.financialctl.financialinfo.infrastructure.adapters.output.exceptions.BadRequestException;
import com.financialctl.financialinfo.infrastructure.adapters.output.exceptions.NotFoundException;
import com.financialctl.financialinfo.utils.builders.UserBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @InjectMocks
    UserService userService;

    @Mock
    UserRepository userRepository;

    @Test
    @DisplayName("Should save user when not already created")
    void shouldSaveUserWhenNotAlreadyCreated() {
        final User user = UserBuilder.getBuilder()
                .name("Vitor")
                .email("vitor@gmail.com")
                .finance(new Finance())
                .build();

        userService.save(user);

        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    @DisplayName("Should throw exception when user is already created")
    void shouldThrowExceptionWhenUserAlreadyCreated() {
        final User user = UserBuilder.getBuilder()
                .name("Pedro")
                .email("pedro@gmail.com")
                .finance(new Finance())
                .build();

        when(userRepository.save(any(User.class)))
                .thenThrow(DataIntegrityViolationException.class);

        assertThrows(BadRequestException.class, () -> userService.save(user));
    }

    @Test
    @DisplayName("Should update operation when operation exists")
    void shouldUpdateOperationWhenOperationExists() {

        User user = new User();
        user.setId(1L);

        when(userRepository.findById(anyLong()))
                .thenReturn(Optional.of(new User()));
        when(userRepository.save(any(User.class)))
                .thenReturn(new User());

        userService.update(user);

        verify(userRepository, times(1))
                .save(any(User.class));
    }

    @Test
    @DisplayName("Should throw NotFoundException when user does not exist in update flow")
    void shouldThrowNotFoundExceptionWhenUserDoesNotExistInUpdateFlow() {
        final User user = new User();
        user.setId(1L);

        when(userRepository.findById(anyLong()))
                .thenReturn(Optional.ofNullable(null));

        final NotFoundException notFoundException = assertThrows(NotFoundException.class, () -> userService.update(user));

        assertThat(notFoundException.getMessage()).isEqualTo("User not found with id 1.");

        verify(userRepository, times(0))
                .save(any(User.class));
    }

    @Test
    @DisplayName("Should delete user when user exists")
    void shouldDeleteUserWhenUserExists() {

        when(userRepository.findById(anyLong()))
                .thenReturn(Optional.of(new User()));

        userService.delete(1L);

        verify(userRepository, times(1))
                .delete(anyLong());
    }

    @Test
    @DisplayName("Should throw NotFoundException when user does not exist in delete flow")
    void shouldThrowNotFoundExceptionWhenUserDoesNotExistInDeleteFlow() {

        when(userRepository.findById(anyLong()))
                .thenReturn(Optional.ofNullable(null));

        final NotFoundException notFoundException = assertThrows(NotFoundException.class, () -> userService.delete(1L));

        assertThat(notFoundException.getMessage()).isEqualTo("User not found with id 1.");

        verify(userRepository, times(0))
                .delete(anyLong());
    }

    @Test
    @DisplayName("Should return user when user object is present")
    void shouldReturnUserWhenUserIsPresent() {

        when(userRepository.findById(anyLong()))
                .thenReturn(Optional.of(new User()));

        userService.get(1L);

        verify(userRepository, times(1))
                .findById(anyLong());
    }

    @Test
    @DisplayName("Should throw NotFoundException when User does not exist")
    void shouldThrowNotFoundExceptionWhenUserDoesNotExist() {

        when(userRepository.findById(anyLong()))
                .thenReturn(Optional.ofNullable(null));

        final NotFoundException notFoundException = assertThrows(NotFoundException.class, () -> userService.get(1L));

        assertThat(notFoundException.getMessage()).isEqualTo("User not found with id 1.");

        verify(userRepository, times(1))
                .findById(anyLong());
    }
}
