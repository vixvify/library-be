package com.app.library.domain.ports;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.app.library.domain.models.Book;

public interface BookRepositoryPort {

    List<Book> findAll();

    Optional<Book> findById(UUID id);

    Book save(Book book);

    boolean existsById(UUID id);

    void deleteById(UUID id);
}