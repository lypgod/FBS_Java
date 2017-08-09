package com.lypgod.fbs.Common.Exception;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

public class ValidationException extends RuntimeException {
    private List<String> message = new ArrayList<>();

    public ValidationException(BindingResult bindingResult) {
        super("Validation failed.");
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            message.add(fieldError.getDefaultMessage());
        }
    }

    ExceptionResponse getExceptionResponse() {
        Integer code = 400;
        return ExceptionResponse.create(code, message);
    }
}
