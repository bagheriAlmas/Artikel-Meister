package org.example.artikelmeister.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.artikelmeister.entity.AppUser;
import org.example.artikelmeister.entity.CaseType;
import org.example.artikelmeister.entity.GermanWord;
import org.example.artikelmeister.entity.GermanWordCreateRequest;
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
    public GermanWord create(GermanWordCreateRequest request) {

        GermanWord germanWord = GermanWord.builder()
                .word(request.word())
                .article(request.article())
                .caseType(CaseType.AKKUSATIV)
                .user(getCurrentUser())
                .build();

        return wordRepository.save(germanWord);
    }

    private AppUser getCurrentUser() {
        final var authentication = SecurityContextHolder.getContext().getAuthentication();
        final var username = authentication.getName();
        return customUserDetailsService.loadUserByUsername(username);
    }
}
