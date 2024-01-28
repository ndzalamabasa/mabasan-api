package com.heroku.java.services;

import com.heroku.java.exceptions.ValidateDataException;

public interface MessageService {
    Integer saveMessage(Integer visitorId, String message) throws ValidateDataException;
}
