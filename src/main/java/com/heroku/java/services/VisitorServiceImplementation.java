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
        Visitor visitorWithSameEmail = visitorRepository.getVisitorByEmail(visitorEmail);

        if(visitorWithSameEmail != null) {
            throw new EtAuthException("visitor exists");
        }

        Integer visitorId = visitorRepository.addVisitor(visitorName, visitorEmail);

        return visitorRepository.getVisitorById(visitorId);
    }
}
