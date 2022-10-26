package com.financialctl.financialinfo.infrastructure.adapters.input.rest.controllers;

import com.financialctl.financialinfo.application.ports.inbound.UserServicePort;
import com.financialctl.financialinfo.domain.models.User;
import com.financialctl.financialinfo.infrastructure.adapters.input.rest.dtos.user.UserRequestDTO;
import com.financialctl.financialinfo.infrastructure.adapters.input.rest.dtos.user.UserResponseDTO;
import com.financialctl.financialinfo.infrastructure.adapters.input.rest.mappers.UserMapper;
import com.financialctl.financialinfo.infrastructure.adapters.input.rest.openapi.UserOpenApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.financialctl.financialinfo.infrastructure.utils.ApiConstants.REQUEST_RECEIVED;
import static com.financialctl.financialinfo.infrastructure.utils.ApiConstants.REQUEST_RESPONSE_WITH_BODY;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/users")
public class UserController implements UserOpenApi {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);
    private final UserServicePort service;

    public UserController(final UserServicePort service) {
        this.service = service;
    }

    @PostMapping
    @Override
    public ResponseEntity<UserResponseDTO> createUser(@Valid @RequestBody final UserRequestDTO user) {
        logger.info(REQUEST_RECEIVED, "createUser", "POST", user);

        final User newUser = service.save(requestToUser(user));
        final UserResponseDTO userResponseDTO = userToResponse(newUser);

        logger.info(REQUEST_RESPONSE_WITH_BODY, "createUser", CREATED.value(), userResponseDTO);

        return ResponseEntity.status(CREATED).body(userResponseDTO);
    }

    private User requestToUser(final UserRequestDTO user) {
        return UserMapper.INSTANCE.userRequestDtoToUser(user);
    }

    private UserResponseDTO userToResponse(final User user) {
        return UserMapper.INSTANCE.userToUserResponseDto(user);
    }
}
