package com.lypgod.fbs.Common.Exception;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {
    private Logger logger = LogManager.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value= HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ExceptionResponse generalException(Exception e) {
        e.printStackTrace();
        List<String> message = new ArrayList<>();
        message.add(e.getMessage());
        return new ExceptionResponse(500, message);
    }

    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(value= HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ExceptionResponse validationException(ValidationException e) {
        return e.getExceptionResponse();
    }

    @ExceptionHandler(LoginException.class)
    @ResponseStatus(value= HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ExceptionResponse loginException(LoginException e) {
        return e.getExceptionResponse();
    }

    @ExceptionHandler(AuthenticationException.class)
    @ResponseStatus(value= HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public ExceptionResponse authenticationException(AuthenticationException e) {
        return e.getExceptionResponse();
    }
}
