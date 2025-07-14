package org.example.artikelmeister.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.artikelmeister.entity.AppUser;
import org.example.artikelmeister.exception.UsernameNotFoundException;
import org.example.artikelmeister.repository.UserRepository;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CustomUserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public AppUser loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(UsernameNotFoundException::new);
    }
}
