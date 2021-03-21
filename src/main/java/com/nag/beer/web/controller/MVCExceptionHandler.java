package com.nag.beer.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class MVCExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<List> validationErrorHandler(ConstraintViolationException ex) {
        List<String> allErrors = new ArrayList<>(ex.getConstraintViolations().size());

        ex.getConstraintViolations().forEach( constraintViolation -> {
            allErrors.add(constraintViolation.getPropertyPath()+" : "+constraintViolation.getMessage());
        });

        return new ResponseEntity<>(allErrors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BindException.class)
    public ResponseEntity<List> handleBindException(BindException exception)
    {
        return new ResponseEntity<>(exception.getAllErrors(), HttpStatus.BAD_REQUEST);
    }

}
