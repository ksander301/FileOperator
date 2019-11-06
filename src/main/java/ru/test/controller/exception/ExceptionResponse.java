package ru.test.controller.exception;


import java.util.Date;

public class ExceptionResponse {
    private Date timestamp;
    private String message;
    private String details;
    private String httpStatusMessage;
    public ExceptionResponse(Date timestamp, String message, String details,String httpStatusMessage) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
        this.httpStatusMessage = httpStatusMessage;
    }
    public String getHttpStatusMessage() {
        return httpStatusMessage;
    }
    public Date getTimestamp() {
        return timestamp;
    }
    public String getMessage() {
        return message;
    }
    public String getDetails() {
        return details;
    }
}