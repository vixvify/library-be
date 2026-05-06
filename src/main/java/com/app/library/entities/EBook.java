package com.app.library.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("EBOOK")
public class EBook extends Book {

    public EBook() {
    }

    public EBook(String title) {
        super(title, 14);
    }

    @Override
    public String getType() {
        return "EBOOK";
    }

}
