package com.heroku.java.exceptions;

public class ValidateDataException extends RuntimeException{

    public ValidateDataException(String message) {
        super(message);
    }
}
