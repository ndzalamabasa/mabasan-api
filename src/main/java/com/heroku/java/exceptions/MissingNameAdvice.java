package com.heroku.java.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class MissingNameAdvice {

    @ResponseBody
    @ExceptionHandler(MissingNameException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    String missingNameHandler(MissingNameException ex) {
        return ex.getMessage();
    }

}
