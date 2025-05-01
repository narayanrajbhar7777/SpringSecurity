package com.product.handler;

import com.product.exceptions.ProductException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProductExceptionHandler {

    @ExceptionHandler
    @ResponseStatus
    public String handlerProductException(ProductException e){
        return e.getMessage();
    }
}
