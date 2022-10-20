package com.financialctl.financialinfo.controllers.openapi;

import com.financialctl.financialinfo.dtos.UserDto;
import com.financialctl.financialinfo.dtos.UserPostDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;

public interface UserOpenApi {

    @Operation(summary = "Creates a new user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User created"),
            @ApiResponse(responseCode = "400", description = "User already created"),
            @ApiResponse(responseCode = "403", description = "Forbidden")
    })
    ResponseEntity<UserDto> createUser(final UserPostDTO userPostDto);
}
