package com.app.library.exceptions;

public class BookNotBorrowedException extends RuntimeException {
    public BookNotBorrowedException() {
        super("Book is not borrowed");
    }
}
