package com.app.library.dto.request;

import lombok.Data;

@Data
public class CreateBookRequest {
    private String title;
    private String type;
}
