package com.heroku.java;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/visitors")
@RequiredArgsConstructor
public class VisitorController {
    private final DataSource dataSource;
    private VisitorService visitorService;

    @GetMapping
    ResponseEntity<List<Visitor>> database(Map<String, Object> model) {
        try (Connection connection = dataSource.getConnection()) {
            final var statement = connection.createStatement();

            final var resultSet = statement.executeQuery("SELECT * FROM visitors");

            return new ResponseEntity<List<Visitor>> (visitorService.allVisitors(), HttpStatus.OK);

        } catch (Throwable t) {
            model.put("message", t.getMessage());
            return new ResponseEntity<List<Visitor>> (visitorService.allVisitors(), HttpStatus.NOT_FOUND);
        }
//        return new ResponseEntity<List<Visitor>>(visitorService.allVisitors(),HttpStatus.OK);
    }

    @GetMapping("1")
    public ResponseEntity<List<Visitor>> getVisitors(){
        System.out.println("There is nothing here!");
        return new ResponseEntity<List<Visitor>>(visitorService.allVisitors(),HttpStatus.OK);
    }
}
