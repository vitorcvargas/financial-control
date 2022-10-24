package com.financialctl.financialinfo.infrastructure.adapters.output.persistence.entities.enums;

public enum OperationTypeDB {
    INCOME(1),
    EXPENSE(2);


    private int type;

    OperationTypeDB(final int type) {
        this.type = type;
    }

    public OperationTypeDB fromValue(final int value) {
        for (OperationTypeDB operationTypeDB : OperationTypeDB.values()) {
            if (operationTypeDB.getType() == value)
                return operationTypeDB;
        }
        return null;
    }

    public int getType() {
        return type;
    }
}
