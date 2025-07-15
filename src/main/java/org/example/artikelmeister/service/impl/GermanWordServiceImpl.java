package org.example.artikelmeister.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.artikelmeister.entity.*;
import org.example.artikelmeister.entity.dto.GermanWordCreateRequest;
import org.example.artikelmeister.entity.dto.GermanWordCreateResponse;
import org.example.artikelmeister.entity.dto.GermanWordFetchResponse;
import org.example.artikelmeister.entity.enums.Article;
import org.example.artikelmeister.entity.enums.CaseType;
import org.example.artikelmeister.exception.GermanWordNotFoundException;
import org.example.artikelmeister.repository.GermanWordRepository;
import org.example.artikelmeister.service.GermanWordService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GermanWordServiceImpl implements GermanWordService {
    private final GermanWordRepository wordRepository;
    private final CustomUserDetailsServiceImpl customUserDetailsService;

    @Override
    public GermanWordCreateResponse create(GermanWordCreateRequest request) {

        final var germanWord = GermanWord.from(request, getCurrentUser());

        final var result = wordRepository.save(germanWord);
        return GermanWordCreateResponse.from(result);
    }

    @Override
    public GermanWordFetchResponse findWord(String word, Article article, CaseType caseType) {
        final var germanWord = wordRepository.findGermanWordByWordAndArticleAndCaseType(word, article, caseType).orElseThrow(GermanWordNotFoundException::new);
        return GermanWordFetchResponse.from(germanWord, getCurrentUser());
    }

    private AppUser getCurrentUser() {
        final var authentication = SecurityContextHolder.getContext().getAuthentication();
        final var username = authentication.getName();
        return customUserDetailsService.loadUserByUsername(username);
    }
}
