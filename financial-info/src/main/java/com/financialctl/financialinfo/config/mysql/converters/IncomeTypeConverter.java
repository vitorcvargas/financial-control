package com.financialctl.financialinfo.config.mysql.converters;

import com.financialctl.financialinfo.domain.models.enums.IncomeType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class IncomeTypeConverter implements AttributeConverter<IncomeType, Integer> {

    @Override
    public Integer convertToDatabaseColumn(IncomeType incomeType) {
        if (incomeType == null) {
            return null;
        }
        return incomeType.getType();
    }

    @Override
    public IncomeType convertToEntityAttribute(Integer type) {
        if (type == null) {
            return null;
        }

        return Stream.of(IncomeType.values())
                .filter(c -> c.getType() == type)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
