package com.heroku.java.repositories;

import com.heroku.java.exceptions.EtAuthException;

public interface MessageRepo {
    Integer saveMessage(Integer visitorId, String message ) throws EtAuthException;

}
