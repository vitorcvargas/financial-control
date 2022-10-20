package com.financialctl.financialinfo.controllers;

import com.financialctl.financialinfo.config.integration.IntegrationTestBase;
import com.financialctl.financialinfo.dtos.UserDTO;
import com.financialctl.financialinfo.dtos.UserPostDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

public class UserControllerIT extends IntegrationTestBase {

    @Autowired
    UserController userController;

    @Test
    void test() {
        final UserPostDTO user = new UserPostDTO("Vitor", "vitor@email.com");

        final ResponseEntity<UserDTO> response = userController.createUser(user);

        assertThat(response.getBody()).isNotNull();
    }
}
