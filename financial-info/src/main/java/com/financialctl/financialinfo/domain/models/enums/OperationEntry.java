package com.financialctl.financialinfo.domain.models.enums;

import static com.financialctl.financialinfo.domain.models.enums.OperationType.EXPENSE;
import static com.financialctl.financialinfo.domain.models.enums.OperationType.INCOME;

public enum OperationEntry {
    HOUSING(1, "Housing", EXPENSE),
    TRANSPORTATION(2, "Transportation", EXPENSE),
    FOOD(3, "Food", EXPENSE),
    UTILITIES(4, "Utilities", EXPENSE),
    CLOTHING(5, "Clothing", EXPENSE),
    HEALTHCARE(6, "Healthcare", EXPENSE),
    INSURANCE(7, "Insurance", EXPENSE),
    SUPPLIES(8, "Supplies", EXPENSE),
    PERSONAL(9, "Personal", EXPENSE),
    DEBT(10, "Debt", EXPENSE),
    RETIREMENT(11, "Retirement", EXPENSE),
    EDUCATION(12, "Education", EXPENSE),
    SAVINGS(13, "Savings", EXPENSE),
    GIFTS(14, "Gifts", EXPENSE),
    ENTERTAINMENT(15, "Entertainment", EXPENSE),
    EARNED(16, "Earned", INCOME),
    PROFIT(17, "Profit", INCOME),
    INTEREST(18, "Interest", INCOME),
    DIVIDEND(19, "Dividend", INCOME),
    RENTAL(20, "Rental", INCOME),
    CAPITAL_GAINS(21, "Capital gains", INCOME),
    ROYALTY(22, "Royalty", INCOME);

    private int id;
    private String description;
    private OperationType operationType;

    OperationEntry(final int id, final String description, final OperationType operationType) {
        this.id = id;
        this.description = description;
        this.operationType = operationType;
    }

    public static OperationEntry fromId(final int id) {
        for (OperationEntry operationEntry : OperationEntry.values()) {
            if (operationEntry.getId() == id)
                return operationEntry;
        }
        return null;
    }

    public int getId() {
        return id;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public String getDescription() {
        return description;
    }
}
