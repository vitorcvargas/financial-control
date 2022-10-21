package com.financialctl.financialinfo.infrastructure.adapters.input.rest.controllers;

import com.financialctl.financialinfo.infrastructure.adapters.input.rest.dtos.user.UserRequestDTO;
import com.financialctl.financialinfo.infrastructure.adapters.input.rest.openapi.UserOpenApi;
import com.financialctl.financialinfo.infrastructure.adapters.input.rest.dtos.user.UserResponseDTO;
import com.financialctl.financialinfo.application.ports.inbound.CRUDService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.financialctl.financialinfo.infrastructure.adapters.utils.ApiConstants.REQUEST_RECEIVED;
import static com.financialctl.financialinfo.infrastructure.adapters.utils.ApiConstants.REQUEST_RESPONSE_WITH_BODY;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/users")
public class UserController implements UserOpenApi {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);
    private final CRUDService service;

    public UserController(final CRUDService service) {
        this.service = service;
    }

    @PostMapping
    @Override
    public ResponseEntity<UserResponseDTO> createUser(@Valid @RequestBody final UserRequestDTO user) {
        logger.info(REQUEST_RECEIVED, "createUser", "POST", user);

        final UserResponseDTO newUser = (UserResponseDTO) service.save(user);

        logger.info(REQUEST_RESPONSE_WITH_BODY, "createUser", CREATED.value(), newUser);

        return ResponseEntity.status(CREATED).body(newUser);
    }
}
