package com.financialctl.financialinfo.exceptions;

import static com.financialctl.financialinfo.exceptions.ExceptionMessage.USER_ALREADY_CREATED;

public class BadRequestException extends GlobalException {


    public static BadRequestException userAlreadyCreated(final String email) {
        return new BadRequestException(USER_ALREADY_CREATED, email);
    }

    public BadRequestException(final ExceptionMessage exceptionMessage, final String... args) {
        super(exceptionMessage, args);
    }
}
