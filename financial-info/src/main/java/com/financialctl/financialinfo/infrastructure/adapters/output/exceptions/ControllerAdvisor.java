package com.financialctl.financialinfo.infrastructure.adapters.output.exceptions;

import com.financialctl.financialinfo.infrastructure.adapters.input.rest.controllers.UserController;
import com.financialctl.financialinfo.infrastructure.adapters.input.rest.mappers.ExceptionResponseMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ControllerAdvice
public class ControllerAdvisor {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ExceptionResponse> handleCityNotFoundException(final BadRequestException ex) {
        return getResponseEntity(ex);
    }

    private ResponseEntity<ExceptionResponse> getResponseEntity(final GlobalException ex) {
        final ExceptionResponse response = ExceptionResponseMapper.INSTANCE.globalExceptionToExceptionResponse(ex);
        logger.error("{}", response);
        return new ResponseEntity<>(response, BAD_REQUEST);
    }
}
