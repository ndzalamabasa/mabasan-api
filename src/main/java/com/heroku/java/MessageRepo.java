package com.heroku.java;

import com.heroku.java.exceptions.EtAuthException;

public interface MessageRepo {
    Message saveMessage(String message ) throws EtAuthException;
}
