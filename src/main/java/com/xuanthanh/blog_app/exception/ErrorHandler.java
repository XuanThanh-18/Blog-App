package com.xuanthanh.blog_app.exception;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.LinkedHashMap;

@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatusCode status,
            WebRequest request) {
        var message = "Du lieu khong hop le";
        var detail = new LinkedHashMap<String,String>();
        for(var error : ex.getFieldErrors()){
            var key = error.getField();
            var value = error.getDefaultMessage();
            detail.put(key,value);
        }
        var errorResponse = new ErrorResponse(message,detail);
        return new ResponseEntity<>(errorResponse,headers,status);
    }
    @ExceptionHandler(value = ConstraintViolationException.class)
    public ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException exception){
        var message = "Du lieu khong hop le";
        var details = new LinkedHashMap<String,String>();
        for(var error : exception.getConstraintViolations()){
            var key = error.getPropertyPath().toString();
            var value = error.getMessage();
            details.put(key,value);
        }
        var errorResponse = new ErrorResponse(message,details);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
