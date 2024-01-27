package com.heroku.java;

import com.heroku.java.exceptions.EtAuthException;

public interface MessageService {
    Visitor saveMessage(String message) throws EtAuthException;
}
