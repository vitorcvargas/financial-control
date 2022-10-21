package com.financialctl.financialinfo.infrastructure.adapters.output.persistence.config.mysql.converters;

import com.financialctl.financialinfo.infrastructure.adapters.output.persistence.entity.enums.IncomeTypeDB;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class IncomeTypeConverter implements AttributeConverter<IncomeTypeDB, Integer> {

    @Override
    public Integer convertToDatabaseColumn(IncomeTypeDB incomeType) {
        if (incomeType == null) {
            return null;
        }
        return incomeType.getType();
    }

    @Override
    public IncomeTypeDB convertToEntityAttribute(Integer type) {
        if (type == null) {
            return null;
        }

        return Stream.of(IncomeTypeDB.values())
                .filter(c -> c.getType() == type)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
