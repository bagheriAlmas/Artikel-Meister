package org.example.artikelmeister.service;

import org.example.artikelmeister.entity.dto.GermanWordCreateRequest;
import org.example.artikelmeister.entity.dto.GermanWordCreateResponse;
import org.example.artikelmeister.entity.dto.GermanWordFetchResponse;
import org.example.artikelmeister.entity.enums.Article;
import org.example.artikelmeister.entity.enums.CaseType;

public interface GermanWordService {
    GermanWordCreateResponse create(GermanWordCreateRequest germanWord);
    GermanWordFetchResponse findWord(String word, Article article, CaseType caseType);
}
