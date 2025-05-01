package com.caching.handler;

import com.caching.exceptions.StudentException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    @ResponseStatus
    public String handleStudentNotFoundException(StudentException ex){
        return ex.getMessage();
    }
}
