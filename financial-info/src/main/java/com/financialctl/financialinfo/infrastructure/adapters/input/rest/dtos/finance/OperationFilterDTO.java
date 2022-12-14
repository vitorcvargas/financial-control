package com.financialctl.financialinfo.infrastructure.adapters.input.rest.dtos.finance;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.financialctl.financialinfo.domain.models.enums.OperationEntry;
import com.financialctl.financialinfo.domain.models.enums.OperationType;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.Valid;
import java.util.List;

public class OperationFilterDTO {

    @Schema(
            description = "Filter operations containing an entry type",
            example = "[\"TRANSPORTATION\",\"HOUSING\"]"
    )
    @JsonProperty("operation_entries")
    private List<OperationEntry> operationEntryTypes;

    @Valid
    private WindowDTO window;

    @Schema(
            description = "Filter operations containing a description",
            example = "[\"Mc\",\"BK\"]"
    )
    private List<String> descriptions;

    @Schema(
            description = "Filter operations by operation type",
            example = "EXPENSE"
    )
    @JsonProperty("operation_type")
    private OperationType operationType;

    public OperationFilterDTO() {
    }

    public OperationFilterDTO(final List<OperationEntry> operationEntryTypes, final WindowDTO window, final List<String> descriptions, final OperationType operationType) {
        this.operationEntryTypes = operationEntryTypes;
        this.window = window;
        this.descriptions = descriptions;
        this.operationType = operationType;
    }

    public List<OperationEntry> getOperationEntryTypes() {
        return operationEntryTypes;
    }

    public void setOperationEntryTypes(final List<OperationEntry> operationEntryTypes) {
        this.operationEntryTypes = operationEntryTypes;
    }

    public WindowDTO getWindow() {
        return window;
    }

    public void setWindow(final WindowDTO windowDTO) {
        this.window = windowDTO;
    }

    public List<String> getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(final List<String> descriptions) {
        this.descriptions = descriptions;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public void setOperationType(final OperationType operationType) {
        this.operationType = operationType;
    }


    @Override
    public String toString() {
        return "OperationFilterDTO{" +
                "operationEntryTypes=" + operationEntryTypes +
                ", window=" + window +
                ", descriptions=" + descriptions +
                ", operationType=" + operationType +
                '}';
    }
}
