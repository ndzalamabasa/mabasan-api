package com.heroku.java.repositories;

import com.heroku.java.entities.Visitor;
import com.heroku.java.exceptions.EtAuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;

@Repository
public class VisitorRepoImplementation implements VisitorRepository {

    private static final String INSERT_VISITOR = "INSERT INTO visitors(visitor_name, visitor_email) VALUES ( ?, ?)";
    private static final String GET_VISITOR_BY_ID = "SELECT * FROM visitors WHERE visitor_id = ?";
    private static final String GET_VISITOR_BY_EMAIL = "SELECT * FROM visitors WHERE visitor_email = ?";

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public Integer addVisitor(String visitorName, String visitorEmail) throws EtAuthException {
        try{
            KeyHolder keyHolder = new GeneratedKeyHolder();

            jdbcTemplate.update(con -> {
                PreparedStatement ps = con.prepareStatement(INSERT_VISITOR, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, visitorName);
                ps.setString(2, visitorEmail);

                return ps;
            }, keyHolder);

            return (Integer) keyHolder.getKeys().get("visitor_id");
        } catch(Exception e){
            throw new EtAuthException("Invalid details, failed to add a visitor");
        }
    }

    @Override
    public Visitor getVisitorById(Integer visitorId) {
        return jdbcTemplate.queryForObject(GET_VISITOR_BY_ID, visitorRowMapper, visitorId);
    }

    @Override
    public Visitor getVisitorByEmail(String visitorEmail) {
        return jdbcTemplate.queryForObject(GET_VISITOR_BY_EMAIL, visitorRowMapper, visitorEmail);
    }

    private final RowMapper<Visitor> visitorRowMapper = ((rs, rowNum) ->{
        return new Visitor(
                rs.getInt("visitor_id"),
                rs.getString("visitor_name"),
                rs.getString("visitor_email"));
    });

}
