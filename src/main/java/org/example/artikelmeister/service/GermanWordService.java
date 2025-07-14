package org.example.artikelmeister.service;

import org.example.artikelmeister.entity.dto.GermanWordCreateRequest;
import org.example.artikelmeister.entity.dto.GermanWordCreateResponse;

public interface GermanWordService {
    GermanWordCreateResponse create(GermanWordCreateRequest germanWord);
}
