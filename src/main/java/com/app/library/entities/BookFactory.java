package com.app.library.entities;

import java.util.Objects;

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
