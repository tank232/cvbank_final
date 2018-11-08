package com.telran.cvbank.controller;

import com.telran.cvbank.exception.InputValidationException;
import com.telran.cvbank.model.web.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorController {

    @ExceptionHandler(value = InputValidationException.class)
    public ResponseEntity<ErrorResponse> getErrorResponse(InputValidationException e) {
        e.printStackTrace();
        return new ResponseEntity<>(e.getErrorResponse(), HttpStatus.BAD_REQUEST);
    }
}