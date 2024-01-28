package com.heroku.java.repositories;


import com.heroku.java.entities.Visitor;
import com.heroku.java.exceptions.EtAuthException;
import com.heroku.java.exceptions.ValidateDataException;

public interface VisitorRepository {

    Integer addVisitor(String visitorName, String visitorEmail) throws ValidateDataException;

    Visitor getVisitorById(Integer visitorId);

    Visitor getVisitorByEmail(String visitorEmail);

    Integer visitorEmailCount(String visitorEmail);

}
