package com.financialctl.financialinfo.infrastructure.adapters.output.persistence.mappers;

import com.financialctl.financialinfo.domain.models.Expense;
import com.financialctl.financialinfo.infrastructure.adapters.output.persistence.entity.ExpenseDB;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ExpenseDBMapper {
    ExpenseDBMapper INSTANCE = Mappers.getMapper(ExpenseDBMapper.class);

    ExpenseDB expenseToExpenseDB(final Expense expense);

    Expense expenseDBToExpense(final ExpenseDB expenseDB);
}
