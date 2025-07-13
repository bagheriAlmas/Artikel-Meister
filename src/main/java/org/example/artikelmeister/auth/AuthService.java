package org.example.artikelmeister.auth;

import lombok.RequiredArgsConstructor;
import org.example.artikelmeister.entity.*;
import org.example.artikelmeister.exception.UsernameAlreadyExistsException;
import org.example.artikelmeister.exception.UsernameNotFoundException;
import org.example.artikelmeister.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        if (userRepository.findByUsername(request.username()).isPresent())
            throw new UsernameAlreadyExistsException();

        final var user = AppUser.of(request.username(), passwordEncoder.encode(request.password()), Role.USER);
        userRepository.save(user);

        final var token = jwtService.generateToken(user);
        return new AuthenticationResponse(token);
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        var user = userRepository.findByUsername(request.username()).orElseThrow(UsernameNotFoundException::new);

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.username(), request.password()));

        var token = jwtService.generateToken(user);
        return new AuthenticationResponse(token);
    }

}
