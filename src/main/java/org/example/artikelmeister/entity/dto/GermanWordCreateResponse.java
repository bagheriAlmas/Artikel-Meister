package org.example.artikelmeister.entity.dto;

import lombok.AccessLevel;
import lombok.Builder;
import org.example.artikelmeister.entity.GermanWord;
import org.example.artikelmeister.entity.enums.Article;
import org.example.artikelmeister.entity.enums.CaseType;

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
