package com.example.orderItemService.exception;

import java.util.Date;

public class ValidationException extends RuntimeException {

    private Date timestamp;
    private String errorMessage;
    private String details;


    public ValidationException() {
    }

    public ValidationException(String message, String errorMessage) {
        super(message);
        this.errorMessage = errorMessage;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }



}
