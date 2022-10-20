package com.financialctl.financialinfo.domain.models.enums;

public enum IncomeType {

    EARNED(1),
    PROFIT(2),
    INTEREST(3),
    DIVIDEND(4),
    RENTAL(5),
    CAPITAL_GAINS(6),
    ROYALTY(7);

    private int type;

    IncomeType(final int type) {
        this.type = type;
    }

    public IncomeType fromValue(final int value) {
        for (IncomeType incomeType : IncomeType.values()) {
            if (incomeType.getType() == value)
                return incomeType;
        }
        return null;
    }

    public int getType() {
        return type;
    }
}
