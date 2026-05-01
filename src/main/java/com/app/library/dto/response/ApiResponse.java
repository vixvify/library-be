package com.app.library.dto.response;

import lombok.Getter;

@Getter
public class ApiResponse<T> {
    private T data;
    private String error;
    private int status;
    private String statusCode;

    public ApiResponse(T data) {
        this.data = data;
        this.status = 200;
        this.statusCode = "SUCCESS";
    }
}
