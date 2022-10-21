package com.financialctl.financialinfo.infrastructure.adapters.output.persistence.entity.enums;

public enum IncomeTypeDB {

    EARNED(1),
    PROFIT(2),
    INTEREST(3),
    DIVIDEND(4),
    RENTAL(5),
    CAPITAL_GAINS(6),
    ROYALTY(7);

    private int type;

    IncomeTypeDB(final int type) {
        this.type = type;
    }

    public IncomeTypeDB fromValue(final int value) {
        for (IncomeTypeDB incomeTypeDB : IncomeTypeDB.values()) {
            if (incomeTypeDB.getType() == value)
                return incomeTypeDB;
        }
        return null;
    }

    public int getType() {
        return type;
    }
}
