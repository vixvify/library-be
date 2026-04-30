package com.app.library.controllers;

import java.util.UUID;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.library.services.BookService;
import com.app.library.dto.request.CreateBookRequest;

@RestController
@RequestMapping("/api/library")
public class BookController {
    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @PostMapping("/books")
    public void createBook(@RequestBody CreateBookRequest request) {
        service.createBook(request);
    }

    @PutMapping("/books/{id}/borrow")
    public void borrowBook(@PathVariable UUID id) {
        service.borrowBook(id);
    }
}
