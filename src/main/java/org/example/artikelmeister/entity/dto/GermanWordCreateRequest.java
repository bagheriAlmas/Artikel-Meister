package org.example.artikelmeister.entity.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.example.artikelmeister.entity.enums.Article;
import org.example.artikelmeister.entity.enums.CaseType;

public record GermanWordCreateRequest(
        @NotBlank(message = "error.word.notBlank") String word,
        @NotNull(message = "error.article.notNull") Article article,
        @NotNull(message = "error.caseType.notNull") CaseType caseType) {
}
