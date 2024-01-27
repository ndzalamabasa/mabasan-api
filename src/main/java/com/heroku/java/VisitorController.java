package com.heroku.java;

import java.util.HashMap;
import java.util.Map;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/app")
public class VisitorController {

    @Autowired
    VisitorService visitorService;

    @GetMapping
    @ResponseBody
    public ResponseEntity<String> getAllVisitors() {

        return new ResponseEntity<>("Hello app", HttpStatus.OK);
    }

    @PostMapping("/addVisitor")
    public ResponseEntity<Map<String, String>> saveVisitor(@RequestBody Map<String, Object> body) {
        String visitorName = (String) body.get("visitorName");
        String visitorEmail = (String) body.get("visitorEmail");

//        Visitor visitor = visitorService.addVisitor(visitorName, visitorEmail);
        Map<String, String> map = new HashMap<>();
        map.put("message", "visitor added successfully");

        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}
