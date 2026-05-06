package com.app.library.entities;

import jakarta.persistence.Entity;

@Entity
public class PrintedBook extends Book {

    public PrintedBook() {
    }

    public PrintedBook(String title) {
        super(title, 21);
    }

    @Override
    public String getType() {
        return "PRINTED";
    }
}
