package com.app.library.domain.exceptions;

public class BookNotBorrowedException extends RuntimeException {
    public BookNotBorrowedException() {
        super("Book is not borrowed");
    }
}
