package org.example.artikelmeister.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.artikelmeister.entity.dto.UserAnswerCreateRequest;
import org.example.artikelmeister.entity.dto.UserAnswerCreateResponse;
import org.example.artikelmeister.service.UserAnswerService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/answer")
@RequiredArgsConstructor
@Validated
public class UserAnswerController {

    private final UserAnswerService answerService;

    @PostMapping("/create")
    ResponseEntity<UserAnswerCreateResponse> create(@Valid @RequestBody UserAnswerCreateRequest userAnswer){
        final var word = answerService.create(userAnswer);
        return ResponseEntity.ok(word);
    }
}
