package com.financialctl.financialinfo.controllers;

import com.financialctl.financialinfo.infrastructure.adapters.input.rest.controllers.UserController;
import com.financialctl.financialinfo.infrastructure.adapters.input.rest.dtos.user.UserRequestDTO;
import com.financialctl.financialinfo.infrastructure.adapters.input.rest.dtos.user.UserResponseDTO;
import com.financialctl.financialinfo.utils.integration.IntegrationTestBase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

class UserDBControllerIT extends IntegrationTestBase {

    @Autowired
    UserController userController;

    @Test
    void test() {
        final UserRequestDTO user = new UserRequestDTO("Vitor", "vitor@email.com");

        final ResponseEntity<UserResponseDTO> response = userController.createUser(user);

        assertThat(response.getBody()).isNotNull();
    }
}
