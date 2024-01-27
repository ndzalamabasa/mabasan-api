package com.heroku.java;

import com.heroku.java.exceptions.EtAuthException;

public interface MessageService {
    Message saveMessage(String message) throws EtAuthException;
}
