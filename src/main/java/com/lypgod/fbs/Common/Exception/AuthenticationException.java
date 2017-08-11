package com.lypgod.fbs.Common.Exception;

import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AuthenticationException extends RuntimeException {
    private List<String> messages = new ArrayList<>();

    public AuthenticationException() {
        super("Authentication Failed");
        messages.add("Authentication Failed");
    }

    public AuthenticationException(String... messages) {
        super("Authentication Failed");
        this.messages = Arrays.asList(messages);
    }

    ExceptionResponse getExceptionResponse() {
        return ExceptionResponse.create(HttpStatus.UNAUTHORIZED.value(), messages);
    }
}
