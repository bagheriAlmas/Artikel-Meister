package org.example.artikelmeister.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.artikelmeister.entity.AppUser;
import org.example.artikelmeister.entity.GermanWord;
import org.example.artikelmeister.entity.UserAnswer;
import org.example.artikelmeister.entity.dto.GermanWordCreateRequest;
import org.example.artikelmeister.entity.dto.GermanWordCreateResponse;
import org.example.artikelmeister.entity.dto.UserAnswerCreateRequest;
import org.example.artikelmeister.entity.dto.UserAnswerCreateResponse;
import org.example.artikelmeister.repository.GermanWordRepository;
import org.example.artikelmeister.repository.UserAnswerRepository;
import org.example.artikelmeister.service.GermanWordService;
import org.example.artikelmeister.service.UserAnswerService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserAnswerServiceImpl implements UserAnswerService {
    private final UserAnswerRepository answerRepository;
    private final CustomUserDetailsServiceImpl customUserDetailsService;
    private final GermanWordService germanWordService;

    @Override
    public UserAnswerCreateResponse create(UserAnswerCreateRequest request) {

        final var germanWordFetchResponse = germanWordService.findWord(request.word(), request.article(),request.caseType());

        final var germanWord = GermanWord.from(germanWordFetchResponse);

        final var userAnswer = UserAnswer.builder()
                .user(getCurrentUser())
                .word(germanWord)
                .selectedArticle(germanWord.getArticle())
                .isCorrect(true)
                .answeredAt(LocalDateTime.now())
                .build();
        final var result = answerRepository.save(userAnswer);
        return UserAnswerCreateResponse.from(result);
    }

    private AppUser getCurrentUser() {
        final var authentication = SecurityContextHolder.getContext().getAuthentication();
        final var username = authentication.getName();
        return customUserDetailsService.loadUserByUsername(username);
    }
}
