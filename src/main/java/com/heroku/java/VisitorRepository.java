package com.heroku.java;


import com.heroku.java.exceptions.EtAuthException;

public interface VisitorRepository {

    Integer addVisitor(String visitorName, String visitorEmail) throws EtAuthException;

    Visitor getVisitorById(Integer visitorId);
}
