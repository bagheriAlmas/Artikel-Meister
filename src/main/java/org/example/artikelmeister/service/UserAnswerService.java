package org.example.artikelmeister.service;

import org.example.artikelmeister.entity.dto.UserAnswerCreateRequest;
import org.example.artikelmeister.entity.dto.UserAnswerCreateResponse;

public interface UserAnswerService {
    UserAnswerCreateResponse create(UserAnswerCreateRequest germanWord);
}
