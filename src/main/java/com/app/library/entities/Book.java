package com.app.library.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import com.app.library.exceptions.BookNotAvailableException;
import com.app.library.exceptions.BookNotBorrowedException;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

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

    @Column(name = "borrow_days")
    private Integer borrowDays;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    protected Book() {
    }

    protected Book(String title, Integer borrowDays) {
        this.title = title;
        this.borrowDays = borrowDays;
        this.available = true;
        this.createdAt = LocalDateTime.now();
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
