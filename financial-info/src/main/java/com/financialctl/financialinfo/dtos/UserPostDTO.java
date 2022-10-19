package com.financialctl.financialinfo.dtos;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotBlank;

public class UserPostDTO {

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

    public UserPostDTO() {
    }

    public UserPostDTO(final String name, final String email) {
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
        return "UserPostDTO{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
