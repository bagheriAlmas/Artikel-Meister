package org.example.artikelmeister.repository;

import org.example.artikelmeister.entity.GermanWord;
import org.example.artikelmeister.entity.enums.Article;
import org.example.artikelmeister.entity.enums.CaseType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GermanWordRepository extends JpaRepository<GermanWord, Long> {
    Optional<GermanWord> findGermanWordByWordAndArticleAndCaseType(String word, Article article, CaseType caseType);
}
