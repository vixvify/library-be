package com.app.library.dto.response;

import lombok.Getter;

@Getter
public class ApiResponse<T> {
    private T data;
    private String error;
    private int status;
    private String statusCode;

    public ApiResponse(T data, int status, String statusCode) {
        this.data = data;
        this.status = status;
        this.statusCode = statusCode;
    }

    public ApiResponse(String error, int status, String statusCode) {
        this.error = error;
        this.status = status;
        this.statusCode = statusCode;
    }
}
