package com.heroku.java.services;

import com.heroku.java.exceptions.MissingNameException;
import com.heroku.java.repositories.VisitorRepository;
import com.heroku.java.entities.Visitor;
import com.heroku.java.exceptions.EtAuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Transactional
public class VisitorServiceImplementation implements VisitorService {

    @Autowired
    VisitorRepository visitorRepository;

    @Override
    public Visitor addVisitor(String visitorName, String visitorEmail) throws EtAuthException {
        Integer visitorEmailCount = visitorRepository.visitorEmailCount(visitorEmail);

        if(Objects.equals(visitorName, "")){
            throw new MissingNameException("Some of the required fields are missing");
        }

        if(visitorEmailCount > 0) {
            return visitorRepository.getVisitorByEmail(visitorEmail);
        }

        Integer visitorId = visitorRepository.addVisitor(visitorName, visitorEmail);

        return visitorRepository.getVisitorById(visitorId);
    }
}
