package com.financialctl.financialinfo.domain.models.enums;

public enum OperationType {
    INCOME(1),
    EXPENSE(2);


    private int type;

    OperationType(final int type) {
        this.type = type;
    }

    public OperationType fromValue(final int value) {
        for (OperationType operationType : OperationType.values()) {
            if (operationType.getType() == value)
                return operationType;
        }
        return null;
    }

    public int getType() {
        return type;
    }
}
