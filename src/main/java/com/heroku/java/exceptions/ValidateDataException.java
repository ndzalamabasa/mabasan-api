package com.heroku.java.exceptions;

public class MissingNameException extends RuntimeException{

    public MissingNameException(String message) {
        super(message);
    }
}
