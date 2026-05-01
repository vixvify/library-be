package com.app.library.controllers;

import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.app.library.dto.response.ApiResponse;
import com.app.library.exceptions.BookNotAvailableException;
import com.app.library.exceptions.BookNotBorrowedException;
import com.app.library.exceptions.BookNotFoundException;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Void>> handleValidation(MethodArgumentNotValidException exception) {
        String error = exception.getBindingResult().getFieldErrors().stream()
                .map(fieldError -> fieldError.getDefaultMessage())
                .collect(Collectors.joining(", "));

        return errorResponse(error, HttpStatus.BAD_REQUEST, "VALIDATION_ERROR");
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiResponse<Void>> handleIllegalArgument(IllegalArgumentException exception) {
        return errorResponse(exception.getMessage(), HttpStatus.BAD_REQUEST, "BAD_REQUEST");
    }

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<ApiResponse<Void>> handleBookNotFound(BookNotFoundException exception) {
        return errorResponse(exception.getMessage(), HttpStatus.NOT_FOUND, "NOT_FOUND");
    }

    @ExceptionHandler({ BookNotAvailableException.class, BookNotBorrowedException.class })
    public ResponseEntity<ApiResponse<Void>> handleBookState(RuntimeException exception) {
        return errorResponse(exception.getMessage(), HttpStatus.CONFLICT, "CONFLICT");
    }

    private ResponseEntity<ApiResponse<Void>> errorResponse(String error, HttpStatus status, String statusCode) {
        return ResponseEntity.status(status).body(new ApiResponse<>(error, status.value(), statusCode));
    }
}
