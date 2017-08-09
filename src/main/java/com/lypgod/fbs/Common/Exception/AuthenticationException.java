package com.lypgod.fbs.Common.Exception;

import java.util.ArrayList;
import java.util.List;

public class AuthenticationException extends RuntimeException {
    private List<String> message = new ArrayList<>();

    public AuthenticationException() {
    }

    public AuthenticationException(String msg) {
        message.add(msg);
    }

    ExceptionResponse getExceptionResponse() {
        Integer code = 401;
        return ExceptionResponse.create(code, message);
    }
}
