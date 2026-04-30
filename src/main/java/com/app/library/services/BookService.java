package com.app.library.services;

import java.util.UUID;

import com.app.library.dto.request.*;

public interface BookService {

    void createBook(CreateBookRequest request);

    void borrowBook(UUID id);
}
