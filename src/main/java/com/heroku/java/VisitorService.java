package com.heroku.java;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VisitorService {

    @Autowired
    private final VisitorRepository visitorRepo;

    public List<Visitor> allVisitors(){
        return (List<Visitor>) visitorRepo.findAll();

    }

}
