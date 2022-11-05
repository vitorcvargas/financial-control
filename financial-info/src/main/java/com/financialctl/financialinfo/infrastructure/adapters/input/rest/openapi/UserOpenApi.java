package com.financialctl.financialinfo.infrastructure.adapters.input.rest.openapi;

import com.financialctl.financialinfo.infrastructure.adapters.input.rest.dtos.user.UserRequestDTO;
import com.financialctl.financialinfo.infrastructure.adapters.input.rest.dtos.user.UserResponseDTO;
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
    ResponseEntity<UserResponseDTO> createUser(final UserRequestDTO userPostDto);

    @Operation(summary = "Gets an user containing a given id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "User not found"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "405", description = "Method Not Allowed")
    })
    ResponseEntity<UserResponseDTO> getUserById(final Long id);

    @Operation(summary = "Gets an user containing a given email")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "User not found"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "405", description = "Method Not Allowed")
    })
    ResponseEntity<UserResponseDTO> getUserByEmail(final String email);

    @Operation(summary = "Updates an user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "User not found"),
            @ApiResponse(responseCode = "403", description = "Forbidden")
    })
    ResponseEntity<UserResponseDTO> updateUser(final Long id, final UserRequestDTO userPostDto);

    @Operation(summary = "Deletes an user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "User not found"),
            @ApiResponse(responseCode = "405", description = "Method Not Allowed")
    })
    ResponseEntity<String> deleteUser(final Long id);
}
