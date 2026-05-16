package com.app.library.presentation.mapper;

import org.springframework.stereotype.Component;

import com.app.library.domain.models.Book;
import com.app.library.presentation.dto.response.BookResponse;

@Component
public class BookMapper {
    public BookResponse mapToResponse(Book book) {
        BookResponse res = new BookResponse();

        res.setId(book.getId());
        res.setTitle(book.getTitle());
        res.setType(book.getType());
        res.setAvailable(book.isAvailable());
        res.setBorrowDays(book.getBorrowDays());
        res.setCreatedAt(book.getCreatedAt());

        return res;
    }
}
