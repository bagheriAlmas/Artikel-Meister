package org.example.artikelmeister.entity.dto;

import lombok.AccessLevel;
import lombok.Builder;
import org.example.artikelmeister.entity.UserAnswer;
import org.example.artikelmeister.entity.enums.Article;

@Builder(access = AccessLevel.PRIVATE)
public record UserAnswerCreateResponse(Long id, String word, Article article) {
    public static UserAnswerCreateResponse from(UserAnswer answer){
        return UserAnswerCreateResponse.builder()
                .id(answer.getId())
                .word(answer.getWord().getWord())
                .article(answer.getWord().getArticle())
                .build();
    }
}
