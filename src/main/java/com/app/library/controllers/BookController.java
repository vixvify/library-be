package com.app.library.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import com.app.library.services.BookService;
import com.app.library.dto.request.CreateBookRequest;
import com.app.library.entities.Book;
import com.app.library.dto.response.ApiResponse;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/library")
public class BookController {
    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping("/books")
    public ApiResponse<List<Book>> getBooks() {
        return new ApiResponse<>(service.getBooks());
    }

    @PostMapping("/books")
    public ApiResponse<Void> createBook(@RequestBody CreateBookRequest request) {
        service.createBook(request);
        return new ApiResponse<>(null);
    }

    @PutMapping("/books/borrow/{id}")
    public ApiResponse<Void> borrowBook(@PathVariable UUID id) {
        service.borrowBook(id);
        return new ApiResponse<>(null);
    }
}
