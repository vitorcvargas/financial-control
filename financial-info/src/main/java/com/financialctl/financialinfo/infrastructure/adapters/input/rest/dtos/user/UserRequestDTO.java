package com.financialctl.financialinfo.infrastructure.adapters.input.rest.dtos.user;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotBlank;

public class UserRequestDTO {

    @NotBlank
    @Schema(
            description = "User name",
            example = "Vitor"
    )
    private String name;

    @NotBlank
    @Schema(
            description = "User email",
            example = "vitor@email.com"
    )
    private String email;

    public UserRequestDTO() {
    }

    public UserRequestDTO(final String name, final String email) {
        this.name = name;
        this.email = email;
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

    @Override
    public String toString() {
        return "UserRequestDTO{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
