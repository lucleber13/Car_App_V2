package com.cbcode.car_app_v2.User_Packages.model.DTO;

import java.util.Objects;

public class LoginDto {
    private String email;
    private String password;

    public LoginDto() {
    }
    public LoginDto(String email, String password) {
        this.email = email;
        this.password= password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LoginDto loginDto)) return false;
        return Objects.equals(getEmail(), loginDto.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmail());
    }

    @Override
    public String toString() {
        return "LoginDto{" +
                "email='" + email + '\'' +
                '}';
    }
}
