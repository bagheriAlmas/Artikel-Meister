package org.example.artikelmeister.entity.dto;

import lombok.AccessLevel;
import lombok.Builder;
import org.example.artikelmeister.entity.AppUser;
import org.example.artikelmeister.entity.GermanWord;
import org.example.artikelmeister.entity.enums.Article;
import org.example.artikelmeister.entity.enums.CaseType;

@Builder(access = AccessLevel.PRIVATE)
public record GermanWordFetchResponse(
        Long id,
        String word,
        Article article,
        CaseType caseType,
        AppUser user


) {
    public static GermanWordFetchResponse from(GermanWord germanWord, AppUser user) {
        return GermanWordFetchResponse.builder()
                .id(germanWord.getId())
                .word(germanWord.getWord())
                .article(germanWord.getArticle())
                .caseType(germanWord.getCaseType())
                .user(user)
                .build();
    }
}
