package com.heroku.java.services;

import com.heroku.java.exceptions.ValidateDataException;
import com.heroku.java.repositories.VisitorRepository;
import com.heroku.java.entities.Visitor;
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
    public Visitor addVisitor(String visitorName, String visitorEmail) throws ValidateDataException {
        Integer visitorEmailCount = visitorRepository.visitorEmailCount(visitorEmail);

        if(Objects.equals(visitorName, "")){
            throw new ValidateDataException("Some of the required fields are missing");
        }

        if(visitorEmailCount > 0) {
            return visitorRepository.getVisitorByEmail(visitorEmail);
        }

        Integer visitorId = visitorRepository.addVisitor(visitorName, visitorEmail);

        return visitorRepository.getVisitorById(visitorId);
    }
}
