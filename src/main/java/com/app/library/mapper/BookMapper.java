package com.app.library.mapper;

import org.springframework.stereotype.Component;
import com.app.library.dto.response.BookResponse;
import com.app.library.entities.Book;

@Component
public class BookMapper {
    public BookResponse mapToResponse(Book book) {
        BookResponse res = new BookResponse();

        res.setId(book.getId());
        res.setTitle(book.getTitle());
        res.setType(book.getType());
        res.setAvailable(book.isAvailable());
        res.setBorrow_days(book.getBorrow_days());
        res.setCreated_at(book.getCreated_at());

        return res;
    }
}
