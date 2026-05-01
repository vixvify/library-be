package com.app.library.entities;

import jakarta.persistence.Entity;

@Entity
public class EBook extends Book {

    public EBook() {
    }

    public EBook(String title) {
        super(title);
        setType("EBOOK");
        setBorrow_days(14);
    }

}
