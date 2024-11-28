package com._donghh.board._core.exception;

import org.springframework.http.HttpStatus;

public class ApiException extends RuntimeException {

    public final HttpStatus status;

    public ApiException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }
}