package com.financialctl.financialinfo.dtos;

import io.swagger.v3.oas.annotations.media.Schema;

public class UserDTO {

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

    public UserDTO(final String name, final String email) {
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
        return "UserDto{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
