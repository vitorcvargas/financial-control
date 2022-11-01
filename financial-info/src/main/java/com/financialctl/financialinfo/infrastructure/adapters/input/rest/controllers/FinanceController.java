package com.financialctl.financialinfo.infrastructure.adapters.input.rest.controllers;

import com.financialctl.financialinfo.application.ports.inbound.FinanceServicePort;
import com.financialctl.financialinfo.domain.models.Operation;
import com.financialctl.financialinfo.domain.models.OperationFilter;
import com.financialctl.financialinfo.infrastructure.adapters.input.rest.dtos.finance.OperationFilterDTO;
import com.financialctl.financialinfo.infrastructure.adapters.input.rest.dtos.operation.OperationResponseDTO;
import com.financialctl.financialinfo.infrastructure.adapters.input.rest.mappers.OperationFilterMapper;
import com.financialctl.financialinfo.infrastructure.adapters.input.rest.mappers.OperationMapper;
import com.financialctl.financialinfo.infrastructure.adapters.input.rest.openapi.FinanceOpenApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

import static com.financialctl.financialinfo.infrastructure.utils.ApiConstants.REQUEST_RECEIVED;
import static com.financialctl.financialinfo.infrastructure.utils.ApiConstants.REQUEST_RESPONSE_WITH_BODY;
import static org.springframework.http.HttpMethod.GET;
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

    private OperationFilter filterDTOToFilter(final Long id, final OperationFilterDTO filterDTO) {
        return OperationFilterMapper.INSTANCE.operationFilterDTOToOperationFilter(id, filterDTO);
    }

    private List<OperationResponseDTO> operationsToOperationsDTO(final List<Operation> operations) {
        return OperationMapper.INSTANCE.operationsToOperationResponsesDTO(operations);
    }
}
