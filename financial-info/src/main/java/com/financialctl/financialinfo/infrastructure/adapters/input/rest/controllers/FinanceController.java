package com.financialctl.financialinfo.infrastructure.adapters.input.rest.controllers;

import com.financialctl.financialinfo.application.ports.inbound.FinanceServicePort;
import com.financialctl.financialinfo.domain.models.Operation;
import com.financialctl.financialinfo.domain.models.OperationFilter;
import com.financialctl.financialinfo.domain.models.enums.OperationEntry;
import com.financialctl.financialinfo.infrastructure.adapters.input.rest.dtos.finance.OperationFilterDTO;
import com.financialctl.financialinfo.infrastructure.adapters.input.rest.dtos.operation.OperationResponseDTO;
import com.financialctl.financialinfo.infrastructure.adapters.input.rest.mappers.FinanceMapper;
import com.financialctl.financialinfo.infrastructure.adapters.input.rest.mappers.OperationMapper;
import com.financialctl.financialinfo.infrastructure.adapters.input.rest.openapi.FinanceOpenApi;
import com.financialctl.financialinfo.infrastructure.adapters.output.persistence.entities.enums.OperationEntryDB;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

import static com.financialctl.financialinfo.infrastructure.utils.ApiConstants.REQUEST_RECEIVED;
import static com.financialctl.financialinfo.infrastructure.utils.ApiConstants.REQUEST_RESPONSE_WITH_BODY;
import static java.lang.String.format;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/finances")
public class FinanceController implements FinanceOpenApi {

    private final Logger logger = LoggerFactory.getLogger(FinanceController.class);
    private final FinanceServicePort service;

    public FinanceController(final FinanceServicePort service) {
        this.service = service;
    }

    @GetMapping("/operations/{id}")
    @Override
    public ResponseEntity<List<OperationResponseDTO>> filterOperations(@NotNull @PathVariable Long id, @Valid @RequestBody final OperationFilterDTO filter) {
        logger.info(REQUEST_RECEIVED, "filterOperations", GET, id);

        final List<Operation> operations = service.filterOperations(filterDTOToFilter(id, filter));
        final List<OperationResponseDTO> response = operationsToOperationsDTO(operations);

        logger.info(REQUEST_RESPONSE_WITH_BODY, "filterOperations", OK.value(), response);

        return ResponseEntity.status(OK).body(response);
    }

    @PostMapping("/budget/{id}")
    @Override
    public ResponseEntity<Map<OperationEntryDB, Double>> createBudget(@NotNull @PathVariable final Long id, @Valid @RequestBody final Map<OperationEntryDB, Double> budget) {
        final String params = format("id: %s, budget: %s", id, budget);
        logger.info(REQUEST_RECEIVED, "createBudget", POST, params);

        final Map<OperationEntry, Double> newBudget = service.createBudget(id, budgetDTOToBudget(budget));
        final Map<OperationEntryDB, Double> newBudgetDTO = budgetToBudgetDTO(newBudget);

        logger.info(REQUEST_RESPONSE_WITH_BODY, "createBudget", CREATED.value(), newBudgetDTO);

        return ResponseEntity.status(CREATED).body(newBudgetDTO);
    }

    private Map<OperationEntry, Double> budgetDTOToBudget(final Map<OperationEntryDB, Double> budgetDto) {
        return FinanceMapper.INSTANCE.budgetDTOToBudget(budgetDto);
    }

    private Map<OperationEntryDB, Double> budgetToBudgetDTO(final Map<OperationEntry, Double> budget) {
        return FinanceMapper.INSTANCE.budgetToBudgetDTO(budget);
    }

    private OperationFilter filterDTOToFilter(final Long id, final OperationFilterDTO filterDTO) {
        return FinanceMapper.INSTANCE.operationFilterDTOToOperationFilter(id, filterDTO);
    }

    private List<OperationResponseDTO> operationsToOperationsDTO(final List<Operation> operations) {
        return OperationMapper.INSTANCE.operationsToOperationResponsesDTO(operations);
    }
}
