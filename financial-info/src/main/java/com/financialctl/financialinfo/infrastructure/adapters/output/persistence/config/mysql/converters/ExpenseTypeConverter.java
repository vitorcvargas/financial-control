package com.financialctl.financialinfo.infrastructure.adapters.output.persistence.config.mysql.converters;

import com.financialctl.financialinfo.infrastructure.adapters.output.persistence.entity.enums.ExpenseTypeDB;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class ExpenseTypeConverter implements AttributeConverter<ExpenseTypeDB, Integer> {

    @Override
    public Integer convertToDatabaseColumn(ExpenseTypeDB expenseType) {
        if (expenseType == null) {
            return null;
        }
        return expenseType.getType();
    }

    @Override
    public ExpenseTypeDB convertToEntityAttribute(Integer type) {
        if (type == null) {
            return null;
        }

        return Stream.of(ExpenseTypeDB.values())
                .filter(c -> c.getType() == type)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
