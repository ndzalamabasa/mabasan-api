package com.heroku.java.controllers;

import java.util.HashMap;
import java.util.Map;

import com.heroku.java.entities.Message;
import com.heroku.java.exceptions.EtAuthException;
import com.heroku.java.services.MessageService;
import com.heroku.java.services.VisitorService;
import com.heroku.java.entities.Visitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5500", allowedHeaders = "*")
@RestController
@RequestMapping("/api/v1/messages")
public class VisitorController {

    @Autowired
    VisitorService visitorService;

    @Autowired
    MessageService messageService;

    @GetMapping
    @ResponseBody
    public ResponseEntity<String> getAllVisitors() {

        return new ResponseEntity<>("Hello app", HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> saveVisitor(@RequestBody Map<String, Object> body) {
        String visitorName = (String) body.get("visitorName");
        String visitorEmail = (String) body.get("visitorEmail");
        String message = (String) body.get("message");

        Visitor visitor = visitorService.addVisitor(visitorName, visitorEmail);
        Integer newMessage = messageService.saveMessage(visitor.getVisitorId(), message);
        Map<String, String> map = new HashMap<>();
        map.put("success", "message sent successfully");

        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}
