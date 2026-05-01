package com.app.library.services;

import java.util.List;
import java.util.UUID;

import com.app.library.dto.request.*;
import com.app.library.entities.Book;

public interface BookService {

    List<Book> getBooks();

    void createBook(CreateBookRequest request);

    void borrowBook(UUID id);
}
