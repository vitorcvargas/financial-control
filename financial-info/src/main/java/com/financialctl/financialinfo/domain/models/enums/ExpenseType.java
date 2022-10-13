package com.financialctl.financialinfo.domain.models.enums;

public enum ExpenseType {
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

    public ExpenseType fromValue(final int value) {
        for(ExpenseType expenseType : ExpenseType.values()) {
            if(expenseType.getType() == value)
                return expenseType;
        }
        return null;
    }

    private ExpenseType(final int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }
}
