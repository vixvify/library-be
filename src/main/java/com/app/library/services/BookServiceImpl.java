package com.app.library.services;

import com.app.library.entities.Book;
import com.app.library.entities.EBook;
import com.app.library.entities.PrintedBook;
import com.app.library.exceptions.BookNotFoundException;
import com.app.library.infrastructure.BookRepository;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.app.library.dto.request.CreateBookRequest;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository repo;

    public BookServiceImpl(BookRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Book> getBooks() {
        return repo.findAll();
    }

    @Override
    public void createBook(CreateBookRequest request) {
        Book book;

        if ("PRINTED".equalsIgnoreCase(request.getType())) {
            book = new PrintedBook(request.getTitle());
        } else if ("EBOOK".equalsIgnoreCase(request.getType())) {
            book = new EBook(request.getTitle());
        } else {
            throw new IllegalArgumentException("Invalid book type");
        }

        repo.save(book);
    }

    @Override
    public void borrowBook(UUID id) {
        Book book = repo.findById(id).orElseThrow(BookNotFoundException::new);
        book.borrow();
        repo.save(book);
    }

    @Override
    public void returnBook(UUID id) {
        Book book = repo.findById(id).orElseThrow(BookNotFoundException::new);
        book.returnBook();
        repo.save(book);
    }

    @Override
    public void deleteBook(UUID id) {
        if (!repo.existsById(id)) {
            throw new BookNotFoundException();
        }

        repo.deleteById(id);
    }
}
