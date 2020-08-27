package com.example.orderService.exception;

import java.util.Date;

public class OrderNotFoundException extends RuntimeException {
    private Date timestamp;
    private String message;
    private String details;

    public OrderNotFoundException(){

    }

    public OrderNotFoundException(String message) {
        super(message);
        this.message = message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
