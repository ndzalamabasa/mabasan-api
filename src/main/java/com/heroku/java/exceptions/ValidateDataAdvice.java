package com.heroku.java.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MissingNameAdvice {
    Map<Object, Object> errorObject = new HashMap<>();

    @ResponseBody
    @ExceptionHandler(MissingNameException.class)
    ResponseEntity<?> missingNameHandler(MissingNameException ex) {
        errorObject.put("message",ex.getMessage());
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
                .contentType(MediaType.APPLICATION_JSON)
                .body(errorObject);
    }

}
