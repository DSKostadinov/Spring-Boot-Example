package com.springboot.app.exceptions;

import java.util.Collections;
import java.util.List;

public class ErrorResponse {

    private List<String> messages;

    ErrorResponse(List<String> messages) {
        this.messages = messages;
    }

    ErrorResponse(String message) {
        this.messages = Collections.singletonList(message);
    }

    public List<String> getMessages() {
        return messages;
    }
}
