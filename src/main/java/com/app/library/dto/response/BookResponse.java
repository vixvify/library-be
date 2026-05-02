package com.app.library.dto.response;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Data;

@Data
public class BookResponse {
    private UUID id;
    private String title;
    private String type;
    private boolean available;
    private Integer borrow_days;
    private LocalDateTime created_at;
}
