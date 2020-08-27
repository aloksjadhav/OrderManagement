package com.example.orderItemService.exception;

import java.util.Date;

public class OrderItemNotFoundException extends RuntimeException {

    private Date timestamp;
    private String message;
    private String details;

    public OrderItemNotFoundException() {

    }

    public OrderItemNotFoundException(String message) {
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
