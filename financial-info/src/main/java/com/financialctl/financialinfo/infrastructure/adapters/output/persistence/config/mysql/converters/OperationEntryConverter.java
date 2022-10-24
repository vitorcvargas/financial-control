package com.financialctl.financialinfo.infrastructure.adapters.output.persistence.config.mysql.converters;

import com.financialctl.financialinfo.infrastructure.adapters.output.persistence.entities.enums.OperationEntryDB;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class OperationEntryConverter implements AttributeConverter<OperationEntryDB, Integer> {

    @Override
    public Integer convertToDatabaseColumn(OperationEntryDB operationEntry) {
        if (operationEntry == null) {
            return null;
        }
        return operationEntry.getId();
    }

    @Override
    public OperationEntryDB convertToEntityAttribute(Integer id) {
        if (id == null) {
            return null;
        }

        return Stream.of(OperationEntryDB.values())
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
