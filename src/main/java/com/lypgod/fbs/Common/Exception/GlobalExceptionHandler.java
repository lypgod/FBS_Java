package com.lypgod.fbs.Common.Exception;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Collections;

@ControllerAdvice
public class GlobalExceptionHandler {
    private Logger logger = LogManager.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value= HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ExceptionResponse generalException(Exception e) {
        e.printStackTrace();
        return new ExceptionResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), Collections.singletonList(e.getMessage()));
    }

    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(value= HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ExceptionResponse validationException(ValidationException e) {
        return e.getExceptionResponse();
    }

    @ExceptionHandler(LoginFailedException.class)
    @ResponseStatus(value= HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ExceptionResponse loginException(LoginFailedException e) {
        return e.getExceptionResponse();
    }

    @ExceptionHandler(AuthenticationException.class)
    @ResponseStatus(value= HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public ExceptionResponse authenticationException(AuthenticationException e) {
        return e.getExceptionResponse();
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(value= HttpStatus.NOT_FOUND)
    @ResponseBody
    public ExceptionResponse notFoundException(NotFoundException e) {
        return e.getExceptionResponse();
    }
}
