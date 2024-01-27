package com.heroku.java;

import java.util.Map;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

// import java.util.List;

@RestController
@RequestMapping("/app")
public class VisitorController {

    // private final VisitorService visitorService;

    // @Autowired
    // public VisitorController(VisitorService visitorService) {
    // this.visitorService = visitorService;
    // }

    @GetMapping
    @ResponseBody
    public ResponseEntity<String> getAllVisitors() {

        return new ResponseEntity<>("Hello app", HttpStatus.OK);
    }

    @PostMapping("/addVisitor")
    public String addVisitor(@RequestBody Map<String, Object> body) {
        String visitorName = (String) body.get("visitorName");

        return visitorName;
    }
}
