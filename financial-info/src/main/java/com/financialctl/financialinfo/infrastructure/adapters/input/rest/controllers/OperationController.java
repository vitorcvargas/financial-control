package com.financialctl.financialinfo.infrastructure.adapters.input.rest.controllers;

import com.financialctl.financialinfo.application.ports.inbound.OperationServicePort;
import com.financialctl.financialinfo.domain.models.Operation;
import com.financialctl.financialinfo.infrastructure.adapters.input.rest.dtos.operation.OperationRequestDTO;
import com.financialctl.financialinfo.infrastructure.adapters.input.rest.dtos.operation.OperationResponseDTO;
import com.financialctl.financialinfo.infrastructure.adapters.input.rest.mappers.OperationMapper;
import com.financialctl.financialinfo.infrastructure.adapters.input.rest.openapi.OperationOpenApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.financialctl.financialinfo.infrastructure.utils.ApiConstants.REQUEST_RECEIVED;
import static com.financialctl.financialinfo.infrastructure.utils.ApiConstants.REQUEST_RESPONSE_WITH_BODY;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/operations")
public class OperationController implements OperationOpenApi {

    private final Logger logger = LoggerFactory.getLogger(OperationController.class);
    private final OperationServicePort service;

    public OperationController(final OperationServicePort service) {
        this.service = service;
    }

    @PostMapping
    @Override
    public ResponseEntity<OperationResponseDTO> createOperation(@Valid @RequestBody final OperationRequestDTO operation) {
        logger.info(REQUEST_RECEIVED, "createOperation", "POST", operation);

        final Operation newOperation = service.save(requestToOperation(operation));
        final OperationResponseDTO operationResponseDTO = operationToResponse(newOperation);

        logger.info(REQUEST_RESPONSE_WITH_BODY, "createOperation", CREATED.value(), operationResponseDTO);

        return ResponseEntity.status(CREATED).body(operationResponseDTO);
    }

    private Operation requestToOperation(final OperationRequestDTO operationRequestDTO) {
        return OperationMapper.INSTANCE.operationRequestDTOToOperation(operationRequestDTO);
    }

    private OperationResponseDTO operationToResponse(final Operation operation) {
        return OperationMapper.INSTANCE.operationToOperationResponseDTO(operation);
    }
}
