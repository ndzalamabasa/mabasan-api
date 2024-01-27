package com.heroku.java;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    MessageService messageService;
    @PostMapping
    public ResponseEntity<Map<String, String>> saveMessage(@RequestBody Map<String, Object> body) {
        String message = (String) body.get("message");

        Message newMessage = messageService.saveMessage(message);
        Map<String, String> map = new HashMap<>();
        map.put("success", "message was sent");

        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}
