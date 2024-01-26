package com.heroku.java;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class VisitorService {

    private final VisitorRepository visitorRepo;

    public List<Visitor> allVisitors(){
        return (List<Visitor>) visitorRepo.findAll();

    }

    public Visitor getVisitorById(UUID id){
        Optional<Visitor> optionalVisitor = visitorRepo.findById(id);
        return optionalVisitor.orElse(null);

    }

    public Visitor saveVisitor(Visitor visitor){

        return visitorRepo.save(visitor);
    }
}
