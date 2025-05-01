package com.companyproducts.handler;


import com.companyproducts.exceptions.CompanyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CompanyExceptionHandler {

    @ExceptionHandler
    @ResponseStatus
    public String handlerCompanyException(CompanyException e) {
        return e.getMessage();
    }
}
