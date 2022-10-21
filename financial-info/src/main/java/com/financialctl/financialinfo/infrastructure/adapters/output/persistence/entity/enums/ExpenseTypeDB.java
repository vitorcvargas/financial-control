package com.financialctl.financialinfo.infrastructure.adapters.output.persistence.entity.enums;

public enum ExpenseTypeDB {
    HOUSING(1),
    TRANSPORTATION(2),
    FOOD(3),
    UTILITIES(4),
    CLOTHING(5),
    HEALTHCARE(6),
    INSURANCE(7),
    SUPPLIES(8),
    PERSONAL(9),
    DEBT(10),
    RETIREMENT(11),
    EDUCATION(12),
    SAVINGS(13),
    GIFTS(14),
    ENTERTAINMENT(15);
    private int type;

    public ExpenseTypeDB fromValue(final int value) {
        for (ExpenseTypeDB expenseTypeDB : ExpenseTypeDB.values()) {
            if (expenseTypeDB.getType() == value)
                return expenseTypeDB;
        }
        return null;
    }

    ExpenseTypeDB(final int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }
}
