package com.financialctl.financialinfo.infrastructure.adapters.output.exceptions;

public class NotFoundException extends GlobalException {


    public static NotFoundException financeNotFound(final Long id) {
        return new NotFoundException(ExceptionMessage.FINANCE_NOT_FOUND, id.toString());
    }

    public static NotFoundException operationNotFound(final Long id) {
        return new NotFoundException(ExceptionMessage.OPERATION_NOT_FOUND, id.toString());
    }

    public static NotFoundException userNotFound(final Long id) {
        return new NotFoundException(ExceptionMessage.USER_NOT_FOUND, id.toString());
    }

    public NotFoundException(final ExceptionMessage exceptionMessage, final String... args) {
        super(exceptionMessage, args);
    }
}
