package com.appvenir.rezulab.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.appvenir.rezulab.http.ResponseFailure;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice(annotations = RestController.class)
public class RestControllerExceptions {
    
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> handleRuntimeException(RuntimeException ex, HttpServletRequest request)
    {
        var responseFailure = ResponseFailure.set(ex, request.getRequestURI());
        return new ResponseEntity<>(responseFailure, HttpStatus.BAD_REQUEST);
    }

}
