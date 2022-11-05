package com.financialctl.financialinfo.infrastructure.adapters.output.exceptions;

public enum ExceptionMessage {

    USER_ALREADY_CREATED(1, "A user with the email %s was already created."),
    FINANCE_NOT_FOUND(2, "Finance not found with id %s."),
    OPERATION_NOT_FOUND(3, "Operation not found with id %s."),
    USER_NOT_FOUND_WITH_ID(4, "User not found with id %s."),
    USER_NOT_FOUND_WITH_EMAIL(5, "User not found with email %s.");


    private int code;
    private String message;

    ExceptionMessage(final int code, final String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(final int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }
}
