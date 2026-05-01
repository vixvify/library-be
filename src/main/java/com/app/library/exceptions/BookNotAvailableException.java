package com.app.library.exceptions;

public class BookNotAvailableException extends RuntimeException {
    public BookNotAvailableException() {
        super("Book not available");
    }
}
