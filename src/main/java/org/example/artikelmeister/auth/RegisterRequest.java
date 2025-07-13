package org.example.artikelmeister.auth;

import jakarta.validation.constraints.NotBlank;

public record RegisterRequest(
        @NotBlank(message = "error.username.notBlank") String username,
        @NotBlank(message = "error.password.notBlank") String password) {
}