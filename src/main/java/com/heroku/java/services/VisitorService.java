package com.heroku.java.services;

import com.heroku.java.entities.Visitor;
import com.heroku.java.exceptions.ValidateDataException;

public interface VisitorService {

    Visitor addVisitor(String visitorName, String visitorEmail) throws ValidateDataException;
}
