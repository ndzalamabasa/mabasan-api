package com.heroku.java.repositories;

import com.heroku.java.exceptions.EtAuthException;
import com.heroku.java.exceptions.ValidateDataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;

@Repository
public class MessageRepoImplementation implements MessageRepo {
    private static final String INSERT_MESSAGE = "INSERT INTO messages(visitor_id, message) VALUES (?, ?)";

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public Integer saveMessage(Integer visitorId, String message) throws ValidateDataException {
        try{
            KeyHolder keyHolder = new GeneratedKeyHolder();

            jdbcTemplate.update(con -> {
                PreparedStatement ps = con.prepareStatement(INSERT_MESSAGE, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, visitorId);
                ps.setString(2, message);

                return ps;
            }, keyHolder);

            return (Integer) keyHolder.getKeys().get("message_id");
        } catch(Exception e){
            throw new ValidateDataException("message not sent, try again.");
        }
    }
}
