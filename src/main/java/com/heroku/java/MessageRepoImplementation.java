package com.heroku.java;

import com.heroku.java.exceptions.EtAuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;

@Repository
public class MessageRepoImplementation implements MessageRepo{
    private static final String INSERT_MESSAGE = "INSERT INTO messages(message) VALUES (?)";

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public Message saveMessage(String message) throws EtAuthException {
        try{
            KeyHolder keyHolder = new GeneratedKeyHolder();

            jdbcTemplate.update(con -> {
                PreparedStatement ps = con.prepareStatement(INSERT_MESSAGE, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, message);

                return ps;
            }, keyHolder);

            return (Message) keyHolder.getKeys().get("message_id");
        } catch(Exception e){
            throw new EtAuthException("message not sent, try again.");
        }
    }
}
