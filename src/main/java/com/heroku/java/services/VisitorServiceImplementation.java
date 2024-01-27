package com.heroku.java.services;

import com.heroku.java.repositories.VisitorRepository;
import com.heroku.java.entities.Visitor;
import com.heroku.java.exceptions.EtAuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.regex.Pattern;

@Service
@Transactional
public class VisitorServiceImplementation implements VisitorService {

    @Autowired
    VisitorRepository visitorRepository;

    @Override
    public Visitor addVisitor(String visitorName, String visitorEmail) throws EtAuthException {
        Pattern emailPattern = Pattern.compile("^[a-zA-Z0-9. _-]+@[a-zA-Z0-9. -]+\\.[a-zA-Z]$");

        if(visitorEmail != null){
            if(!emailPattern.matcher(visitorEmail).matches()){
                throw new EtAuthException("Invalid email, try again.");
            }

            visitorEmail = visitorEmail.toLowerCase();
        }

        if(visitorName == null || visitorEmail == null){
            throw new EtAuthException("required fields(*) missing.");
        }
        
        Integer visitorId = visitorRepository.addVisitor(visitorName, visitorEmail);


        return visitorRepository.getVisitorById(visitorId);
    }
}
