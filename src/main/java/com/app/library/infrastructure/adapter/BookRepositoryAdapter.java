package com.app.library.infrastructure.adapter;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.app.library.domain.models.Book;
import com.app.library.domain.ports.BookRepositoryPort;
import com.app.library.infrastructure.repository.JpaBookRepository;

@Component
public class BookRepositoryAdapter
        implements BookRepositoryPort {

    private final JpaBookRepository repository;

    public BookRepositoryAdapter(
            JpaBookRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Book> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Book> findById(UUID id) {
        return repository.findById(id);
    }

    @Override
    public Book save(Book book) {
        return repository.save(book);
    }

    @Override
    public boolean existsById(UUID id) {
        return repository.existsById(id);
    }

    @Override
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }
}