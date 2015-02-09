package com.dogTracker.model;

public class ErrorResponse {

    public String code;
    public String message;
    public String description;

    public static final String INVALID_KEY = "INVALID_KEY_VALUE";

    public ErrorResponse() {
    }

    public ErrorResponse(String code, String message, String description) {
        this.code = code;
        this.message = message;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
