package com.heroku.java;

import com.heroku.java.exceptions.EtAuthException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

public interface VisitorService {

    Visitor addVisitor(String visitorName, String visitorEmail) throws EtAuthException;
}
