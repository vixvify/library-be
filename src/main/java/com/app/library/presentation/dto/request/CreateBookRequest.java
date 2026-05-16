package com.app.library.presentation.dto.request;

import com.app.library.domain.enums.BookType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateBookRequest {

    @NotBlank(message = "Title is required")
    private String title;

    @NotNull(message = "Type is required")
    private BookType type;
}
