package com.heroku.java;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitorService {

    private final VisitorRepository visitorRepo;

    @Autowired
    public VisitorService(VisitorRepository visitorRepo) {
        this.visitorRepo = visitorRepo;
    }

    public List<Visitor> allVisitors(){
        return (List<Visitor>) visitorRepo.findAll();
    }
}

