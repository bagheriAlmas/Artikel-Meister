package org.example.artikelmeister.service;

import org.example.artikelmeister.entity.GermanWordCreateRequest;
import org.example.artikelmeister.entity.GermanWordCreateResponse;

public interface GermanWordService {
    GermanWordCreateResponse create(GermanWordCreateRequest germanWord);
}
