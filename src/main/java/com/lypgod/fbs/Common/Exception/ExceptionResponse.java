package com.lypgod.fbs.Common.Exception;

import java.util.List;

public class ExceptionResponse {
    private Integer code;
    private List<String> messages;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    ExceptionResponse(Integer code, List<String> messages) {
        this.code = code;
        this.messages = messages;
    }

    static ExceptionResponse create(Integer code, List<String> messages) {
        return new ExceptionResponse(code, messages);
    }
}
