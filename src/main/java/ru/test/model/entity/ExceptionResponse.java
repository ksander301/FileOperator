package ru.test.model.entity;
import java.util.Date;

/* Created for test custom Exception Response entity
* with @RestControllerAdvice,
* it will not use anywhere with real applications*/

public class ExceptionResponse {
    private Date timestamp;
    private String message;
    private String details;
    private String httpStatus;

    public ExceptionResponse(Date timestamp, String message, String details,String httpStatus) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
        this.httpStatus = httpStatus;
    }
    public String getHttpStatus() {
        return httpStatus;
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