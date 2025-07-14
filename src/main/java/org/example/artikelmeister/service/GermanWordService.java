package org.example.artikelmeister.service;

import org.example.artikelmeister.entity.GermanWord;
import org.example.artikelmeister.entity.GermanWordCreateRequest;

public interface GermanWordService {
    GermanWord create(GermanWordCreateRequest germanWord);
}
