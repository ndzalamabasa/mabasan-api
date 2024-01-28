package com.heroku.java.services;

import com.heroku.java.exceptions.ValidateDataException;
import com.heroku.java.repositories.VisitorRepository;
import com.heroku.java.entities.Visitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.regex.Pattern;

@Service
@Transactional
public class VisitorServiceImplementation implements VisitorService {

    @Autowired
    VisitorRepository visitorRepository;

    @Override
    public Visitor addVisitor(String visitorName, String visitorEmail) throws ValidateDataException {
        if(Objects.equals(visitorName, "") || Objects.equals(visitorEmail, "")){
            throw new ValidateDataException("missing required fields");
        }

        Pattern validEmailPattern = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");

        if(!validEmailPattern.matcher(visitorEmail).matches()){
            throw new ValidateDataException("invalid email");
        }

        visitorEmail = visitorEmail.toLowerCase();

        Integer visitorEmailCount = visitorRepository.visitorEmailCount(visitorEmail);
        if(visitorEmailCount > 0) {
            return visitorRepository.getVisitorByEmail(visitorEmail);
        }

        Integer visitorId = visitorRepository.addVisitor(visitorName, visitorEmail);

        return visitorRepository.getVisitorById(visitorId);
    }
}
