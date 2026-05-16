package com.app.library.services;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.app.library.domain.exceptions.BookNotFoundException;
import com.app.library.domain.models.Book;
import com.app.library.domain.ports.BookRepositoryPort;
import com.app.library.factory.BookFactory;
import com.app.library.presentation.dto.request.CreateBookRequest;
import com.app.library.presentation.dto.request.UpdateBookRequest;
import com.app.library.presentation.dto.response.BookResponse;
import com.app.library.presentation.mapper.BookMapper;

@Service
public class BookService {

    private final BookRepositoryPort repo;
    private final BookMapper bookMapper;

    public BookService(BookRepositoryPort repo, BookMapper bookMapper) {
        this.repo = repo;
        this.bookMapper = bookMapper;
    }

    public List<BookResponse> getBooks() {
        return repo.findAll().stream().map(bookMapper::mapToResponse).toList();
    }

    public void createBook(CreateBookRequest request) {
        Book book = BookFactory.create(request.getTitle(), request.getType());
        repo.save(book);
    }

    public void borrowBook(UUID id) {
        Book book = repo.findById(id).orElseThrow(BookNotFoundException::new);

        book.borrow();
        repo.save(book);
    }

    public void returnBook(UUID id) {
        Book book = repo.findById(id).orElseThrow(BookNotFoundException::new);
        book.returnBook();
        repo.save(book);
    }

    public void updateBook(UUID id, UpdateBookRequest request) {
        Book book = repo.findById(id).orElseThrow(BookNotFoundException::new);
        book.setTitle(request.getTitle());
        repo.save(book);
    }

    public void deleteBook(UUID id) {
        if (!repo.existsById(id)) {
            throw new BookNotFoundException();
        }

        repo.deleteById(id);
    }
}
