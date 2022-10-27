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
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import static com.financialctl.financialinfo.infrastructure.utils.ApiConstants.*;
import static org.springframework.http.HttpMethod.*;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

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
    public ResponseEntity<OperationResponseDTO> createOperation(@Valid @RequestBody final OperationRequestDTO request) {
        logger.info(REQUEST_RECEIVED, "createOperation", POST, request);

        final Operation newOperation = service.save(requestToOperation(request));
        final OperationResponseDTO operationResponseDTO = operationToResponse(newOperation);

        logger.info(REQUEST_RESPONSE_WITH_BODY, "createOperation", CREATED.value(), operationResponseDTO);

        return ResponseEntity.status(CREATED).body(operationResponseDTO);
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<OperationResponseDTO> getOperation(@NotNull @PathVariable final Long id) {
        logger.info(REQUEST_RECEIVED, "getOperation", GET, id);

        final Operation operation = service.get(id);
        final OperationResponseDTO operationResponseDTO = operationToResponse(operation);

        logger.info(REQUEST_RESPONSE_WITH_BODY, "getOperation", OK.value(), operationResponseDTO);

        return ResponseEntity.status(OK).body(operationResponseDTO);
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<OperationResponseDTO> updateOperation(@NotNull @PathVariable final Long id, @RequestBody final OperationRequestDTO request) {
        final String params = String.format("%s, id: {%s}", request, id);
        logger.info(REQUEST_RECEIVED, "updateOperation", PUT, params);

        final Operation operation = service.update(requestToOperation(request, id));
        final OperationResponseDTO operationResponseDTO = operationToResponse(operation);

        logger.info(REQUEST_RESPONSE_WITH_BODY, "updateOperation", OK.value(), operationResponseDTO);

        return ResponseEntity.status(OK).body(operationResponseDTO);
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<String> deleteOperation(@NotNull @PathVariable final Long id) {
        logger.info(REQUEST_RECEIVED, "deleteOperation", DELETE, id);

        service.delete(id);

        logger.info(REQUEST_RESPONSE_WITH_NO_BODY, "deleteOperation", OK.value());

        return ResponseEntity.status(OK).body("Operation deleted");
    }

    private Operation requestToOperation(final OperationRequestDTO operationRequestDTO) {
        return OperationMapper.INSTANCE.operationRequestDTOToOperation(operationRequestDTO);
    }

    private Operation requestToOperation(final OperationRequestDTO operationRequestDTO, final Long id) {
        return OperationMapper.INSTANCE.operationRequestDTOToOperation(operationRequestDTO, id);
    }

    private OperationResponseDTO operationToResponse(final Operation operation) {
        return OperationMapper.INSTANCE.operationToOperationResponseDTO(operation);
    }
}
