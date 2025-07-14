package org.example.artikelmeister.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.artikelmeister.entity.GermanWordCreateRequest;
import org.example.artikelmeister.entity.GermanWordCreateResponse;
import org.example.artikelmeister.service.GermanWordService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/word")
@RequiredArgsConstructor
@Validated
public class GermanWordController {

    private final GermanWordService germanWordService;

    @PostMapping("/create")
    ResponseEntity<GermanWordCreateResponse> create(@Valid @RequestBody GermanWordCreateRequest germanWord){
        final var word = germanWordService.create(germanWord);
        return ResponseEntity.ok(word);
    }
}
