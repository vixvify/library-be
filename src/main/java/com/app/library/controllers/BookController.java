package com.app.library.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import com.app.library.services.BookService;
import com.app.library.dto.request.CreateBookRequest;
import com.app.library.entities.Book;
import com.app.library.dto.response.ApiResponse;

import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/library")
public class BookController {
    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping("/books")
    public ResponseEntity<ApiResponse<List<Book>>> getBooks() {
        return ResponseEntity.ok(new ApiResponse<>(service.getBooks(), 200, "SUCCESS"));
    }

    @PostMapping("/books")
    public ResponseEntity<ApiResponse<Void>> createBook(@Valid @RequestBody CreateBookRequest request) {
        service.createBook(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse<>(null, 201, "CREATED"));
    }

    @PutMapping("/books/borrow/{id}")
    public ResponseEntity<ApiResponse<Void>> borrowBook(@PathVariable UUID id) {
        service.borrowBook(id);
        return ResponseEntity.ok(new ApiResponse<>(null, 200, "SUCCESS"));
    }

    @PutMapping("/books/return/{id}")
    public ResponseEntity<ApiResponse<Void>> returnBook(@PathVariable UUID id) {
        service.returnBook(id);
        return ResponseEntity.ok(new ApiResponse<>(null, 200, "SUCCESS"));
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable UUID id) {
        service.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
}
