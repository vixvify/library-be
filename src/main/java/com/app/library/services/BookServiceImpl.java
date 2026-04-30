package com.app.library.services;

import com.app.library.entities.Book;
import com.app.library.entities.EBook;
import com.app.library.entities.PrintedBook;
import com.app.library.infrastructure.BookRepository;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.app.library.dto.request.CreateBookRequest;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository repo;

    public BookServiceImpl(BookRepository repo) {
        this.repo = repo;
    }

    @Override
    public void createBook(CreateBookRequest request) {
        Book book;

        if (request.getType().equalsIgnoreCase("printed")) {
            book = new PrintedBook(request.getTitle());
        } else if (request.getType().equalsIgnoreCase("ebook")) {
            book = new EBook(request.getTitle());
        } else {
            throw new IllegalArgumentException("Invalid book type");
        }

        repo.save(book);
    }

    @Override
    public void borrowBook(UUID id) {
        Book book = repo.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        book.setAvailable(false);

        book.borrow();
    }
}