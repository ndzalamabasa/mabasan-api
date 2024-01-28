package com.heroku.java.services;

import com.heroku.java.repositories.MessageRepo;
import com.heroku.java.exceptions.EtAuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MessageServiceImplementation implements MessageService {
    @Autowired
    MessageRepo messageRepo;

    @Override
    public Integer saveMessage(Integer visitorId, String message) throws EtAuthException {
        return null;
    }
}
