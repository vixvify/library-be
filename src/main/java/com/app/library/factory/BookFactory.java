package com.app.library.factory;

import java.util.Objects;

import com.app.library.domain.enums.BookType;
import com.app.library.domain.models.Book;
import com.app.library.domain.models.EBook;
import com.app.library.domain.models.PrintedBook;

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
