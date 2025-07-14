package org.example.artikelmeister.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "german_words")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GermanWord implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String word; // مثل: Hund

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Article article; // DER, DIE, DAS

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CaseType caseType; // NOMINATIV, AKKUSATIV, DATIV, GENITIV

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private AppUser user;
}
