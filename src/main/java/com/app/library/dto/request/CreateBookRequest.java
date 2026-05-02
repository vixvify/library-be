package com.app.library.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateBookRequest {

    public enum BookType {
        PRINTED,
        EBOOK
    }

    @NotBlank(message = "Title is required")
    private String title;

    @NotNull(message = "Type is required")
    private BookType type;
}
