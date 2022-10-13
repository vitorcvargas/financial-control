package com.financialctl.financialinfo.dtos;

public class UserPostDto {

    private String name;
    private String email;

    public UserPostDto() {
    }

    public UserPostDto(final String name, final String email) {
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
}
