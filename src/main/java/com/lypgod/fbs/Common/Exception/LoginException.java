package com.lypgod.fbs.Common.Exception;

import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

public class LoginException extends RuntimeException {
    private List<String> message = new ArrayList<>();

    public LoginException(String reason) {
        message.add(reason);
    }

    ExceptionResponse getExceptionResponse() {
        Integer code = HttpStatus.BAD_REQUEST.value();
        return ExceptionResponse.create(code, message);
    }
}
