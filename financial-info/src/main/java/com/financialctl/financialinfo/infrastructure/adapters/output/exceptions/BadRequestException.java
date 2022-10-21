package com.financialctl.financialinfo.infrastructure.adapters.output.exceptions;

public class BadRequestException extends GlobalException {


    public static BadRequestException userAlreadyCreated(final String email) {
        return new BadRequestException(ExceptionMessage.USER_ALREADY_CREATED, email);
    }

    public BadRequestException(final ExceptionMessage exceptionMessage, final String... args) {
        super(exceptionMessage, args);
    }
}
