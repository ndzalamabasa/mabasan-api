package com.heroku.java.services;

import com.heroku.java.repositories.VisitorRepository;
import com.heroku.java.entities.Visitor;
import com.heroku.java.exceptions.EtAuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class VisitorServiceImplementation implements VisitorService {

    @Autowired
    VisitorRepository visitorRepository;

    @Override
    public Visitor addVisitor(String visitorName, String visitorEmail) throws EtAuthException {
        Integer visitorId = visitorRepository.addVisitor(visitorName, visitorEmail);
        if(visitorName == null || visitorEmail == null){
            throw new EtAuthException("required fields(*) missing.");
        }
        return visitorRepository.getVisitorById(visitorId);
    }
}
