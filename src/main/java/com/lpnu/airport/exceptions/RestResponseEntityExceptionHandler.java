package com.lpnu.airport.exceptions;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class RestResponseEntityExceptionHandler {
    @ExceptionHandler(value = BadRequestException.class )
    public ResponseEntity<Object> handleServiceException(final BadRequestException ex, final WebRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ExceptionResponseDTO(ex.getMessage()));
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class )
    public ResponseEntity<Object> handleServiceException(final MethodArgumentNotValidException ex) {

        final String messages = ex.getBindingResult().getAllErrors().stream()
                .map(e -> ex.getBindingResult().getFieldError() == null ? "" : ex.getBindingResult().getFieldError().getField()
                        + " " + e.getDefaultMessage())
                .reduce((s1, s2) -> s1 + "; " + s2)
                .orElse("We have an issue with creating error message");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ExceptionResponseDTO(messages));
    }
}
