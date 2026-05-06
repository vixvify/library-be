package com.app.library.services;

import java.util.List;
import java.util.UUID;

import com.app.library.dto.request.*;
import com.app.library.dto.response.BookResponse;

public interface BookService {

    List<BookResponse> getBooks();

    void createBook(CreateBookRequest request);

    void borrowBook(UUID id);

    void returnBook(UUID id);

    void updateBook(UUID id, UpdateBookRequest request);

    void deleteBook(UUID id);
}
