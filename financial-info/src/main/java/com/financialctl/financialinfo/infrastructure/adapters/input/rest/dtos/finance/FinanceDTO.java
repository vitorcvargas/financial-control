package com.financialctl.financialinfo.infrastructure.adapters.input.rest.dtos.finance;

import io.swagger.v3.oas.annotations.media.Schema;

public class FinanceDTO {

    @Schema(
            description = "Finance id which contains operations",
            example = "1"
    )
    private Long id;

    public FinanceDTO() {
    }

    public FinanceDTO(final Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "FinanceDTO{" +
                "id=" + id +
                '}';
    }
}
