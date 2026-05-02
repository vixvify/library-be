package com.app.library.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import com.app.library.exceptions.BookNotAvailableException;
import com.app.library.exceptions.BookNotBorrowedException;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Getter
@Setter
@Entity
@Table(name = "Book")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Book {
    @Id
    @GeneratedValue()
    private UUID id;
    private String title;
    private boolean available;
    private Integer borrow_days;
    private LocalDateTime created_at;

    public Book() {
    }

    public Book(String title) {
        this.title = title;
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
