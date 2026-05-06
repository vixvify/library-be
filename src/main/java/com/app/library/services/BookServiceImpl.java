package com.app.library.services;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.app.library.dto.request.CreateBookRequest;
import com.app.library.entities.Book;
import com.app.library.entities.EBook;
import com.app.library.entities.PrintedBook;
import com.app.library.exceptions.BookNotFoundException;
import com.app.library.infrastructure.BookRepository;
import com.app.library.dto.response.BookResponse;
import com.app.library.mapper.BookMapper;
import com.app.library.dto.request.UpdateBookRequest;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository repo;
    private final BookMapper bookMapper;

    public BookServiceImpl(BookRepository repo, BookMapper bookMapper) {
        this.repo = repo;
        this.bookMapper = bookMapper;
    }

    @Override
    public List<BookResponse> getBooks() {
        return repo.findAll().stream().map(bookMapper::mapToResponse).toList();
    }

    @Override
    public void createBook(CreateBookRequest request) {
        Book book;

        switch (request.getType()) {
            case PRINTED -> book = new PrintedBook(request.getTitle());
            case EBOOK -> book = new EBook(request.getTitle());
            default -> throw new IllegalArgumentException("Invalid type");
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
    public void updateBook(UUID id, UpdateBookRequest request) {
        Book book = repo.findById(id).orElseThrow(BookNotFoundException::new);
        book.setTitle(request.getTitle());
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
