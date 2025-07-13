package org.example.artikelmeister.auth;
import jakarta.validation.constraints.NotBlank;

public record AuthenticationRequest(
        @NotBlank(message = "یوزرنیم نباید خالی باشه") String username,
        @NotBlank(message = "پسورد نباید خالی باشه") String password) {
}