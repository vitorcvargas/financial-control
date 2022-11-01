package com.financialctl.financialinfo.infrastructure.adapters.input.rest.dtos.finance;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.financialctl.financialinfo.domain.models.enums.OperationEntry;
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

    public OperationFilterDTO() {
    }

    public OperationFilterDTO(final List<OperationEntry> operationEntryTypes, final WindowDTO window, final List<String> descriptions) {
        this.operationEntryTypes = operationEntryTypes;
        this.window = window;
        this.descriptions = descriptions;
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

    @Override
    public String toString() {
        return "OperationFilterDTO{" +
                "operationEntryTypes=" + operationEntryTypes +
                ", windowDTO=" + window +
                ", descriptions=" + descriptions +
                '}';
    }
}
