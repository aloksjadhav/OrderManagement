package com.example.orderService.exception;

import com.example.orderService.vo.ExceptionResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {


    @org.springframework.web.bind.annotation.ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<Object> handleOrderNotFoundException(OrderNotFoundException ex) {
        ExceptionResponse response = new ExceptionResponse();
        response.setMessage(ex.getMessage());
        response.setTimestamp(new Date());
        response.setDetails("DB exception");
        return new ResponseEntity(response, HttpStatus.NOT_FOUND);
    }


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
        MethodArgumentNotValidException methodArgumentNotValidException, HttpHeaders headers, HttpStatus status,
        WebRequest request) {

            BindingResult bindingResult = methodArgumentNotValidException.getBindingResult();
            String fieldName = bindingResult.getFieldError().getField();
             ValidationException validationException = null;
            if ("customerName".equalsIgnoreCase(fieldName)) {
                 validationException =
                    new ValidationException("Missing fields", "Customer name cannot be null");
            }
            else if("shippingAddress".equalsIgnoreCase(fieldName)){
                 validationException =
                    new ValidationException("Missing fields", "Shipping Address cannot be null");
            }
            else if("total".equalsIgnoreCase(fieldName)){
                validationException =
                    new ValidationException("Missing fields", "Total cannot be null");
            }
            else {
                return handleValidationException(new ValidationException("Bad request", "Missing fields in request"));
            }
        return handleValidationException(validationException);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(ValidationException.class)
    public ResponseEntity<Object> handleValidationException(ValidationException ex){
        ExceptionResponse response = new ExceptionResponse();
        response.setMessage(ex.getErrorMessage());
        response.setTimestamp(new Date());
        response.setDetails("Bad request");
        return new ResponseEntity<Object>(response, HttpStatus.NOT_FOUND);
    }

}
