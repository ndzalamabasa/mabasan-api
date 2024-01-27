package com.heroku.java.services;

import com.heroku.java.exceptions.EtAuthException;

public interface MessageService {
    Integer saveMessage(String message) throws EtAuthException;
}
