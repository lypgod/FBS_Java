package com.lypgod.fbs.Common.Exception;

import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NotFoundException extends RuntimeException {
    private List<String> messages = new ArrayList<>();

    public NotFoundException() {
        super("Not Found");
        messages.add("Not Found");
    }

    public NotFoundException(String... messages) {
        super("Not Found");
        this.messages = Arrays.asList(messages);
    }

    ExceptionResponse getExceptionResponse() {
        return ExceptionResponse.create(HttpStatus.NOT_FOUND.value(), this.messages);
    }
}
