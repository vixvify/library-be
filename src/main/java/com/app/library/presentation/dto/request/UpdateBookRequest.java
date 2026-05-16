package com.app.library.presentation.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UpdateBookRequest {
    @NotBlank(message = "Title is required")
    private String title;
}
