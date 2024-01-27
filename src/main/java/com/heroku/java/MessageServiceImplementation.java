package com.heroku.java;

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
    public Integer saveMessage(String message) throws EtAuthException {
        return messageRepo.saveMessage(message);
    }
}
