package com.financialctl.financialinfo.infrastructure.adapters.input.rest.openapi;

import com.financialctl.financialinfo.infrastructure.adapters.input.rest.dtos.finance.OperationFilterDTO;
import com.financialctl.financialinfo.infrastructure.adapters.input.rest.dtos.operation.OperationResponseDTO;
import com.financialctl.financialinfo.infrastructure.adapters.output.persistence.entities.enums.OperationEntryDB;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface FinanceOpenApi {

    @Operation(summary = "Lists a sequence of filtered operations")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Operation not found"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "405", description = "Method Not Allowed")
    })
    ResponseEntity<List<OperationResponseDTO>> filterOperations(final Long id, final OperationFilterDTO filter);

    @Operation(summary = "Creates a budget")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Operation not found"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "405", description = "Method Not Allowed")
    })
    ResponseEntity<Map<OperationEntryDB, Double>> createBudget(final Long id, final Map<OperationEntryDB, Double> budget);
}
