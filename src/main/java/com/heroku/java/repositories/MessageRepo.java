package com.heroku.java.repositories;

import com.heroku.java.exceptions.EtAuthException;

public interface MessageRepo {
    Integer saveMessage(String message ) throws EtAuthException;

}
