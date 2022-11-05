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
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import static com.financialctl.financialinfo.infrastructure.utils.ApiConstants.*;
import static org.springframework.http.HttpMethod.*;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

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
    public ResponseEntity<UserResponseDTO> createUser(@Valid @RequestBody final UserRequestDTO request) {
        logger.info(REQUEST_RECEIVED, "createUser", POST, request);

        final User newUser = service.save(requestToUser(request));
        final UserResponseDTO userResponseDTO = userToResponse(newUser);

        logger.info(REQUEST_RESPONSE_WITH_BODY, "createUser", CREATED.value(), userResponseDTO);

        return ResponseEntity.status(CREATED).body(userResponseDTO);
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<UserResponseDTO> getUserById(@NotNull @PathVariable final Long id) {
        logger.info(REQUEST_RECEIVED, "getUser", GET, id);

        final User user = service.get(id);
        final UserResponseDTO userResponseDTO = userToResponse(user);

        logger.info(REQUEST_RESPONSE_WITH_BODY, "getUser", OK.value(), userResponseDTO);

        return ResponseEntity.status(OK).body(userResponseDTO);
    }

    @GetMapping()
    @Override
    public ResponseEntity<UserResponseDTO> getUserByEmail(@NotNull @RequestParam final String email) {
        logger.info(REQUEST_RECEIVED, "getUserByEmail", GET, email);

        final User user = service.getUserByEmail(email);
        final UserResponseDTO userResponseDTO = userToResponse(user);

        logger.info(REQUEST_RESPONSE_WITH_BODY, "getUserByEmail", OK.value(), userResponseDTO);

        return ResponseEntity.status(OK).body(userResponseDTO);
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<UserResponseDTO> updateUser(@NotNull @PathVariable final Long id, @RequestBody final UserRequestDTO request) {
        final String params = String.format("%s, id: {%s}", request, id);
        logger.info(REQUEST_RECEIVED, "updateUser", PUT, params);

        final User user = service.update(requestToUser(request, id));
        final UserResponseDTO userResponseDTO = userToResponse(user);

        logger.info(REQUEST_RESPONSE_WITH_BODY, "updateUser", OK.value(), userResponseDTO);

        return ResponseEntity.status(OK).body(userResponseDTO);
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<String> deleteUser(@NotNull @PathVariable final Long id) {
        logger.info(REQUEST_RECEIVED, "deleteUser", DELETE, id);

        service.delete(id);

        logger.info(REQUEST_RESPONSE_WITH_NO_BODY, "deleteUser", OK.value());

        return ResponseEntity.status(OK).body("User deleted");
    }

    private User requestToUser(final UserRequestDTO user) {
        return UserMapper.INSTANCE.userRequestDtoToUser(user);
    }

    private User requestToUser(final UserRequestDTO user, final Long id) {
        return UserMapper.INSTANCE.userRequestDtoToUser(user, id);
    }

    private UserResponseDTO userToResponse(final User user) {
        return UserMapper.INSTANCE.userToUserResponseDto(user);
    }
}
