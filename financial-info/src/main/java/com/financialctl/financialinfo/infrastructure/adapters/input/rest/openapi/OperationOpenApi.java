package com.financialctl.financialinfo.infrastructure.adapters.input.rest.openapi;

import com.financialctl.financialinfo.infrastructure.adapters.input.rest.dtos.operation.OperationRequestDTO;
import com.financialctl.financialinfo.infrastructure.adapters.input.rest.dtos.operation.OperationResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;

public interface OperationOpenApi {

    @Operation(summary = "Creates a new operation entry")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Operation entry created"),
            @ApiResponse(responseCode = "403", description = "Forbidden")
    })
    ResponseEntity<OperationResponseDTO> createOperation(final OperationRequestDTO operationRequestDTO);

    @Operation(summary = "Gets an operation")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Operation not found"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "405", description = "Method Not Allowed")
    })
    ResponseEntity<OperationResponseDTO> getOperation(final Long id);

    @Operation(summary = "Updates an operation")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Operation not found"),
            @ApiResponse(responseCode = "403", description = "Forbidden")
    })
    ResponseEntity<OperationResponseDTO> updateOperation(final Long id, final OperationRequestDTO operationRequestDTO);

    @Operation(summary = "Deletes an operation")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Operation not found"),
            @ApiResponse(responseCode = "405", description = "Method Not Allowed")
    })
    ResponseEntity<String> deleteOperation(final Long id);
}
