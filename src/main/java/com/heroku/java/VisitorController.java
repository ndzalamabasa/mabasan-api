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
    String database(Map<String, Object> model) {
        try (Connection connection = dataSource.getConnection()) {
            final var statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS ticks (tick timestamp)");
            statement.executeUpdate("INSERT INTO ticks VALUES (now())");

            final var resultSet = statement.executeQuery("SELECT tick FROM ticks");
            final var output = new ArrayList<>();
            while (resultSet.next()) {
                output.add("Read from DB: " + resultSet.getTimestamp("tick"));
            }

            model.put("records", output);
            return "database";

        } catch (Throwable t) {
            model.put("message", t.getMessage());
            return "error";
        }
//        return new ResponseEntity<List<Visitor>>(visitorService.allVisitors(),HttpStatus.OK);
    }

    @GetMapping("1")
    public ResponseEntity<List<Visitor>> getVisitors(){
        System.out.println("There is nothing here!");
        return new ResponseEntity<List<Visitor>>(visitorService.allVisitors(),HttpStatus.OK);
    }
}
