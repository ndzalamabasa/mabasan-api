package com.heroku.java;

import com.heroku.java.exceptions.EtAuthException;

public interface VisitorService {

    Visitor addVisitor(String visitorName, String visitorEmail) throws EtAuthException;
}
