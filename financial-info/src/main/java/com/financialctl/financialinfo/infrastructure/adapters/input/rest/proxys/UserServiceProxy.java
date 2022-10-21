package com.financialctl.financialinfo.infrastructure.adapters.input.rest.proxys;

import com.financialctl.financialinfo.infrastructure.adapters.input.rest.dtos.user.UserRequestDTO;
import com.financialctl.financialinfo.infrastructure.adapters.input.rest.mappers.UserMapper;
import com.financialctl.financialinfo.infrastructure.adapters.input.rest.dtos.user.UserResponseDTO;
import com.financialctl.financialinfo.domain.models.User;
import com.financialctl.financialinfo.application.ports.inbound.CRUDService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class UserServiceProxy implements CRUDService<UserRequestDTO, UserResponseDTO> {

    private final CRUDService userService;


    public UserServiceProxy(final CRUDService userService) {
        this.userService = userService;
    }

    @Override
    public UserResponseDTO save(final UserRequestDTO user) {
        final User newUser = (User) userService.save(requestToUser(user));
        return userToResponse(newUser);
    }

    private User requestToUser(final UserRequestDTO user) {
        return UserMapper.INSTANCE.userRequestDtoToUser(user);
    }

    private UserResponseDTO userToResponse(final User user) {
        return UserMapper.INSTANCE.userToUserResponseDto(user);
    }
}
