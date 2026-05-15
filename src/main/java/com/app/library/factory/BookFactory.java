package com.app.library.factory;

import java.util.Objects;

import com.app.library.domain.BookType;
import com.app.library.entities.Book;
import com.app.library.entities.EBook;
import com.app.library.entities.PrintedBook;

public final class BookFactory {
    private BookFactory() {
    }

    public static Book create(String title, BookType type) {
        Objects.requireNonNull(type, "Book type is required");

        return switch (type) {
            case PRINTED -> new PrintedBook(title);
            case EBOOK -> new EBook(title);
        };
    }
}
