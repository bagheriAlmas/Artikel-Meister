package org.example.artikelmeister.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record GermanWordCreateRequest(
        @NotBlank(message = "error.word.notBlank") String word,
        @NotNull(message = "error.article.notBlank") Article article,
        @NotNull(message = "error.caseType.notBlank") CaseType caseType) {
}
