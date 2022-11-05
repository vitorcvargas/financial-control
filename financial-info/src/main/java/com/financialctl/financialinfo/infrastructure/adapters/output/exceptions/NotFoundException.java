package com.financialctl.financialinfo.infrastructure.adapters.output.exceptions;

import static java.lang.String.format;

public class NotFoundException extends GlobalException {


    public static NotFoundException financeNotFound(final Long id) {
        return new NotFoundException(ExceptionMessage.FINANCE_NOT_FOUND, format("%s", id));
    }

    public static NotFoundException operationNotFound(final Long id) {
        return new NotFoundException(ExceptionMessage.OPERATION_NOT_FOUND, format("%s", id));
    }

    public static NotFoundException userNotFoundWithId(final Long id) {
        return new NotFoundException(ExceptionMessage.USER_NOT_FOUND_WITH_ID, format("%s", id));
    }

    public static NotFoundException userNotFoundWithEmail(final String email) {
        return new NotFoundException(ExceptionMessage.USER_NOT_FOUND_WITH_EMAIL, format("%s", email));
    }

    public NotFoundException(final ExceptionMessage exceptionMessage, final String... args) {
        super(exceptionMessage, args);
    }
}
