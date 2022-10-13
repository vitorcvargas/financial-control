package com.financialctl.financialinfo.config.mysql.converters;

import com.financialctl.financialinfo.domain.models.enums.ExpenseType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class ExpenseTypeConverter implements AttributeConverter<ExpenseType, Integer> {

    @Override
    public Integer convertToDatabaseColumn(ExpenseType expenseType) {
        if (expenseType == null) {
            return null;
        }
        return expenseType.getType();
    }

    @Override
    public ExpenseType convertToEntityAttribute(Integer type) {
        if (type == null) {
            return null;
        }

        return Stream.of(ExpenseType.values())
                .filter(c -> c.getType() == type)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
