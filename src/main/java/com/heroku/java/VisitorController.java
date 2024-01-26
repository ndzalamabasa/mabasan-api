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

    @GetMapping("/database")
    String database() {
        try (Connection connection = dataSource.getConnection()) {
//            final var statement = connection.createStatement();
//            statement.executeUpdate("CREATE TABLE IF NOT EXISTS ticks (tick timestamp)");
//            statement.executeUpdate("INSERT INTO ticks VALUES (now())");
//            final var resultSet = statement.executeQuery("SELECT visitor FROM visitors");
//            final var output = new ArrayList<Visitor>();
//            while (resultSet.next()) {
//                // Assuming Visitor has a constructor that takes a timestamp as an argument
//                output.add(new Visitor(resultSet.id, resultSet.visitor_name, ));
//            }
//            // Use ResponseEntity.ok() to create a BodyBuilder with status code 200
//            // Use BodyBuilder.body() to set the body of the response with the output list
//            return ResponseEntity.ok().body(output);
            return "Connected";
        } catch (Throwable t) {
            // Use ResponseEntity.status() to create a BodyBuilder with status code 500 (Internal Server Error)
            // Use BodyBuilder.body() to set the body of the response with the error message
            return "Not Connected";
        }
    }

    @GetMapping("1")
    public ResponseEntity<List<Visitor>> getVisitors(){
        System.out.println("There is nothing here!");
        return new ResponseEntity<List<Visitor>>(visitorService.allVisitors(),HttpStatus.OK);
    }
}
