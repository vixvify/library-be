package com.app.library.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import com.app.library.exceptions.BookNotAvailableException;
import com.app.library.exceptions.BookNotBorrowedException;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Getter
@Entity
@Table(name = "Book")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "book_type")
public abstract class Book {
    @Id
    @GeneratedValue()
    private UUID id;

    @Setter
    private String title;

    private boolean available;
    private Integer borrow_days;
    private LocalDateTime created_at;

    protected Book() {
    }

    protected Book(String title, Integer borrow_days) {
        this.title = title;
        this.borrow_days = borrow_days;
        this.available = true;
        this.created_at = LocalDateTime.now();
    }

    public void borrow() {
        if (!available) {
            throw new BookNotAvailableException();
        }
        this.available = false;
    }

    public void returnBook() {
        if (available) {
            throw new BookNotBorrowedException();
        }
        this.available = true;
    }

    public abstract String getType();

}
