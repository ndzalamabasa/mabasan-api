package com.heroku.java.repositories;

import com.heroku.java.exceptions.ValidateDataException;

public interface MessageRepo {
    Integer saveMessage(Integer visitorId, String message ) throws ValidateDataException;

}
