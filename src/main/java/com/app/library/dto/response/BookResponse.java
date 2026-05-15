package com.app.library.dto.response;

import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class BookResponse {
    private UUID id;
    private String title;
    private String type;
    private boolean available;

    @JsonProperty("borrow_days")
    private Integer borrowDays;

    @JsonProperty("created_at")
    private LocalDateTime createdAt;
}
