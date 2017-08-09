package com.lypgod.fbs.Common.Exception;

import java.util.List;

public class ExceptionResponse {
    private Integer code;
    private List<String> message;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public List<String> getMessage() {
        return message;
    }

    public void setMessage(List<String> message) {
        this.message = message;
    }

    ExceptionResponse(Integer code, List<String> message) {
        this.code = code;
        this.message = message;
    }

    static ExceptionResponse create(Integer code, List<String> message) {
        return new ExceptionResponse(code, message);
    }
}
