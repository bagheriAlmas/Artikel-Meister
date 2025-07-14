package org.example.artikelmeister.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.artikelmeister.entity.dto.GermanWordCreateRequest;
import org.example.artikelmeister.entity.enums.Article;
import org.example.artikelmeister.entity.enums.CaseType;

import java.io.Serializable;

@Entity
@Table(name = "german_words")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(access = AccessLevel.PRIVATE)
public class GermanWord implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String word;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Article article;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CaseType caseType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private AppUser user;

    public static GermanWord from(GermanWordCreateRequest request, AppUser user) {
        return GermanWord.builder()
                .word(request.word())
                .article(request.article())
                .caseType(request.caseType())
                .user(user)
                .build();
    }
}
