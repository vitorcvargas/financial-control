package com.financialctl.financialinfo.controllers;

import com.financialctl.financialinfo.controllers.openapi.UserOpenApi;
import com.financialctl.financialinfo.domain.services.UserService;
import com.financialctl.financialinfo.dtos.UserPostDTO;
import com.financialctl.financialinfo.exceptions.GlobalException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.financialctl.financialinfo.utils.ApiConstants.REQUEST_RECEIVED;
import static com.financialctl.financialinfo.utils.ApiConstants.REQUEST_RESPONSE_WITH_BODY;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/users")
public class UserController implements UserOpenApi {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;

    public UserController(final UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @Override
    public ResponseEntity<String> createUser(@Valid @RequestBody final UserPostDTO userPostDto) {
        logger.info(REQUEST_RECEIVED, "createUser", "POST", userPostDto);
        userService.createUser(userPostDto);
        final String response = "User created";
        logger.info(REQUEST_RESPONSE_WITH_BODY, "createUser", CREATED.value(), response);
        return ResponseEntity.status(CREATED).body(response);
    }
}
