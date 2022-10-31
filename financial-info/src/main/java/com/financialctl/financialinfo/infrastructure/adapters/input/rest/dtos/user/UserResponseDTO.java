package com.financialctl.financialinfo.infrastructure.adapters.input.rest.dtos.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

public class UserResponseDTO {

    @Schema(
            description = "User id",
            example = "1"
    )
    private Long id;

    @Schema(
            description = "User name",
            example = "Vitor"
    )
    private String name;

    @Schema(
            description = "User email",
            example = "vitor@email.com"
    )
    private String email;

    @Schema(
            description = "Finance id",
            example = "1"
    )
    @JsonProperty("finance_id")
    private Long financeId;

    public UserResponseDTO(final Long id, final String name, final String email, final Long financeId) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.financeId = financeId;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Long getFinanceId() {
        return financeId;
    }

    public void setFinanceId(final Long financeId) {
        this.financeId = financeId;
    }

    @Override
    public String toString() {
        return "UserResponseDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", financeId=" + financeId +
                '}';
    }
}
