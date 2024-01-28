package com.heroku.java.repositories;


import com.heroku.java.entities.Visitor;
import com.heroku.java.exceptions.EtAuthException;

public interface VisitorRepository {

    Integer addVisitor(String visitorName, String visitorEmail) throws EtAuthException;

    Visitor getVisitorById(Integer visitorId);

    Visitor getVisitorByEmail(String visitorEmail);

}
