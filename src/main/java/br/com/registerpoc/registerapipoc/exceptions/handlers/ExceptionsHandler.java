package br.com.registerpoc.registerapipoc.exceptions.handlers;

import br.com.registerpoc.registerapipoc.exceptions.AccountAlreadyApprovedException;
import br.com.registerpoc.registerapipoc.exceptions.models.ErrorResponse;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.webjars.NotFoundException;

import java.time.Instant;

@RestControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ErrorResponse> handlerUsernameNotFound(BadCredentialsException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(
                Instant.now().toEpochMilli(),
                exception.getMessage()
        ));
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<ErrorResponse> handlerUsernameNotFound(UsernameNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(
                Instant.now().toEpochMilli(),
                exception.getMessage()
        ));
    }

    @ExceptionHandler(SecurityException.class)
    public ResponseEntity<ErrorResponse> handlerUsernameNotFound(SecurityException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(
                Instant.now().toEpochMilli(),
                exception.getMessage()
        ));
    }

    @ExceptionHandler(AccountAlreadyApprovedException.class)
    public ResponseEntity<ErrorResponse> handlerUsernameNotFound(AccountAlreadyApprovedException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(
                Instant.now().toEpochMilli(),
                exception.getMessage()
        ));
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handlerUsernameNotFound(NotFoundException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(
                Instant.now().toEpochMilli(),
                exception.getMessage()
        ));
    }

    @ExceptionHandler(ExpiredJwtException.class)
    public ResponseEntity<ErrorResponse> handlerUsernameNotFound(ExpiredJwtException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(
                Instant.now().toEpochMilli(),
                "expired token"
        ));
    }
}
