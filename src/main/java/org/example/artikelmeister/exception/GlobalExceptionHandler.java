package org.example.artikelmeister.exception;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

@ControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    private final MessageSource messageSource;

    @ExceptionHandler(UsernameAlreadyExistsException.class)
    public ResponseEntity<Map<String, String>> handleUsernameAlreadyExists(UsernameAlreadyExistsException ex, Locale locale) {
        logger.warn("UsernameAlreadyExistsException: {}", ex.getMessage());
        return generateException("error.username.already.exists", HttpStatus.CONFLICT, locale);
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleUsernameNotFound(UsernameNotFoundException ex , Locale locale) {
        logger.warn("UsernameNotFoundException: {}", ex.getMessage());
        return generateException("error.username.notFound", HttpStatus.NOT_FOUND, locale);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<Map<String, String>> handleBadCredentials(BadCredentialsException ex, Locale locale) {
        logger.warn("BadCredentialsException: {}", ex.getMessage());
        return generateException("error.password.invalid", HttpStatus.UNAUTHORIZED, locale);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleArgumentNotValidException(MethodArgumentNotValidException ex, Locale locale) {
        logger.warn("MethodArgumentNotValidException: {}", ex.getMessage());
        return generateMultilineException(ex, HttpStatus.BAD_REQUEST, locale);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<Map<String, String>> handleNotFound(NoHandlerFoundException ex, Locale locale) {
        logger.warn("NoHandlerFoundException: {}", ex.getMessage());
        return generateException("error.notFound", HttpStatus.NOT_FOUND, locale);
    }

    private ResponseEntity<Map<String ,String>> generateException(String code, HttpStatus status, Locale locale) {
        String message = messageSource.getMessage(code, null, locale);
        Map<String, String> response = new HashMap<>();
        response.put("error", message);
        return new ResponseEntity<>(response, status);
    }


    private ResponseEntity<Map<String ,String>> generateMultilineException(MethodArgumentNotValidException ex, HttpStatus status, Locale locale) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> errors.put(error.getField(),messageSource.getMessage(Objects.requireNonNull(error.getDefaultMessage()), null, locale)));
        return new ResponseEntity<>(errors,status);
    }
}
