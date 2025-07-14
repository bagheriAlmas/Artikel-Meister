package org.example.artikelmeister.repository;

import org.example.artikelmeister.entity.GermanWord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GermanWordRepository extends JpaRepository<GermanWord, Long> {
}
