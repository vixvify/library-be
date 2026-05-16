package com.app.library.domain.exceptions;

public class BookNotAvailableException extends RuntimeException {
    public BookNotAvailableException() {
        super("Book not available");
    }
}
