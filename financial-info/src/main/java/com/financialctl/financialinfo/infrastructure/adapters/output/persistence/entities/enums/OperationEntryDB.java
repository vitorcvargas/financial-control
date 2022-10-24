package com.financialctl.financialinfo.infrastructure.adapters.output.persistence.entities.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.financialctl.financialinfo.infrastructure.adapters.output.persistence.entities.enums.OperationTypeDB.EXPENSE;
import static com.financialctl.financialinfo.infrastructure.adapters.output.persistence.entities.enums.OperationTypeDB.INCOME;


public enum OperationEntryDB {
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
    private OperationTypeDB operationType;

    OperationEntryDB(final int id, final String description, final OperationTypeDB operationType) {
        this.id = id;
        this.description = description;
        this.operationType = operationType;
    }

    public static OperationEntryDB fromId(final int id) {
        for (OperationEntryDB operationEntryDB : OperationEntryDB.values()) {
            if (operationEntryDB.getId() == id)
                return operationEntryDB;
        }
        return null;
    }

    public List<OperationEntryDB> getIncomeEntries() {
        return Arrays.stream(OperationEntryDB.values())
                .filter(entry -> entry.getOperationType().name().equals("INCOME"))
                .collect(Collectors.toList());
    }

    public List<OperationEntryDB> getExpenseEntries() {
        return Arrays.stream(OperationEntryDB.values())
                .filter(entry -> entry.getOperationType().name().equals("EXPENSE"))
                .collect(Collectors.toList());
    }

    public int getId() {
        return id;
    }

    public OperationTypeDB getOperationType() {
        return operationType;
    }

    public String getDescription() {
        return description;
    }

}
