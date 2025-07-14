package org.example.artikelmeister.entity;

import lombok.AccessLevel;
import lombok.Builder;

@Builder(access = AccessLevel.PRIVATE)
public record GermanWordCreateResponse(Long id, String word, Article article, CaseType caseType) {
    public static GermanWordCreateResponse from(GermanWord germanWord){
        return GermanWordCreateResponse.builder()
                .id(germanWord.getId())
                .word(germanWord.getWord())
                .article(germanWord.getArticle())
                .caseType(germanWord.getCaseType())
                .build();
    }
}
