package com.example.orderItemService.exception;

import com.example.orderItemService.vo.ExceptionResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(OrderItemNotFoundException.class)
    public ResponseEntity handleOrderItemNotFoundException(OrderItemNotFoundException ex) {
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setMessage(ex.getMessage());
        exceptionResponse.setDetails("Order Item not found");
        exceptionResponse.setTimestamp(new Date());
        return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
    }


    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        BindingResult bindingResult = ex.getBindingResult();
        String fieldName = bindingResult.getFieldError().getField();
        ValidationException validationException = null;
        if ("productCode".equals(fieldName)) {
            validationException = new ValidationException("Product Code cannot be null", "Bad Request");
        } else if ("productName".equals(fieldName)){
            validationException = new ValidationException("Product Name cannot be null", "Bad Request");
        } else {
            return handleValidationException(new ValidationException("Bad request", "Missing fields in request"));
        }
        return handleValidationException(validationException);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(ValidationException.class)
    public ResponseEntity<Object> handleValidationException(ValidationException ex) {
        ExceptionResponse response = new ExceptionResponse();
        response.setMessage(ex.getErrorMessage());
        response.setTimestamp(new Date());
        response.setDetails(ex.getMessage());
        return new ResponseEntity<Object>(response, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(DAOException.class)
    public ResponseEntity handleDAOException(DAOException ex) {
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setMessage(ex.getMessage());
        exceptionResponse.setDetails("DAO Exception");
        exceptionResponse.setTimestamp(new Date());
        return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }



}
