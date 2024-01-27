package com.heroku.java;

import com.heroku.java.exceptions.EtAuthException;

public interface MessageService {
    Integer saveMessage(String message) throws EtAuthException;
}
