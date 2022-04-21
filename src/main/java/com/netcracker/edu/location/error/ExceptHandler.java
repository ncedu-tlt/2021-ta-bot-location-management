package com.netcracker.edu.location.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptHandler {

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String PlaceByCategoryNotFoundException(PlaceByCategoryNotFoundException placeByCategoryNotFoundException) {
        return placeByCategoryNotFoundException.getMessage();
    }
}
