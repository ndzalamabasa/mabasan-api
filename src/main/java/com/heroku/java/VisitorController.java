package com.heroku.java;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class VisitorController {
    @Autowired
    private final VisitorService visitorService;

    @GetMapping("/visitors")
    public ResponseEntity<List<Visitor>> getAllVisitors(){
        return new ResponseEntity<List<Visitor>>(visitorService.allVisitors(),HttpStatus.OK);
    }
}
